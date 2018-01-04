package ru.job4j.tracker;

/**
 * Класс обработчик заявок
 * @author AKats
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    /**
     * Генерирование Id заявки.
     * @return id заявки
     */
    private String generateId() {
        return Integer.toString(this.position);
    }

    /**
     * Поиск элемента по ID
     * @param id - id для поиска жлемента
     * @return - элемент с этим id
     */
    protected Item findById(String id) {
        for (Item item : this.items
             ) {
            if (item != null) {
                if (id.equals(item.getId())) {
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * Добавление элемента в трекер
     * @param item - элемент для добавления
     * @return - добавленный элемент
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Замена элемента в трекере
     * @param id - id элемента, который менять
     * @param item - элемент на который менять
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Удаление элемента по id
     * @param id - id удаляемого элемента
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i+1, this.items, i, this.items.length - 1 - i);
                break;
            }
        }
    }

    /**
     * Получение списка всех заявок
     * @return массив всех заявок
     */
    public Item[] findAll() {
        return this.items;
    }

    /**
     * Поиск всех элементов с заданым именем
     * @param name - имя для поиска
     * @return - массив элементов с искомым именем
     */
    public Item[] findByName(String name) {
        Item[] resItems = new Item[100];
        int i = 0;
        for (Item item : this.items
                ) {
            if (item != null) {
                if (name.equals(item.getName())) {
                    resItems[i++] = item;
                }
            }
        }
        return resItems;
    }
}
