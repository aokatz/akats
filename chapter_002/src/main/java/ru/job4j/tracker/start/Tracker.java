package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.*;

/**
 * Класс обработчик заявок
 *
 * @author AKats
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int position = 0;

    /**
     * Поиск элемента по ID
     *
     * @param id - id для поиска элемента
     * @return - элемент с этим id
     */
    protected Item findById(String id) {
        return this.items.stream().filter(item -> id.equals(item.getId())).findFirst().get();
    }

    /**
     * Добавление элемента в трекер
     *
     * @param item - элемент для добавления
     * @return - id добавленного элемента
     */
    public Item add(Item item) {
        item.setId(String.valueOf(position++));
        this.items.add(item);
        return item;
    }

    /**
     * Замена элемента в трекере
     *
     * @param id   - id элемента, который менять
     * @param item - элемент на который менять
     */
    public void replace(String id, Item item) {
        Collections.replaceAll(this.items, this.findById(id), item);
    }

    /**
     * Удаление элемента по id
     *
     * @param id - id удаляемого элемента
     */
    public void delete(String id) {
        this.items.remove(findById(id));
    }

    /**
     * Получение списка всех заявок
     *
     * @return массив всех заявок
     */
    public Item[] findAll() {
        return this.items.toArray(new Item[0]);
    }

    /**
     * Поиск всех элементов с заданым именем
     *
     * @param name - имя для поиска
     * @return - массив элементов с искомым именем
     */
    public Item[] findByName(String name) {
        Item[] resItems = new Item[position];
        int i = 0;
        for (Item item : this.items
                ) {
            if (item != null) {
                if (name.equals(item.getName())) {
                    resItems[i++] = item;
                }
            }
        }
        return Arrays.stream(resItems)
                .filter(item -> item != null)
                .toArray(Item[]::new);
    }
}
