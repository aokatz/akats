package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню отображения всех заявок.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска всех заявок по имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW_ALL:
                    this.showAllItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.findById();
                    break;
                case FIND_BY_NAME:
                    this.findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует отображение всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Отображение всех заявок --------------");
        Arrays.stream(this.tracker.findAll()).forEach(System.out::println);
        System.out.println("-----------------------");
    }

    /**
     * Метод реализует редактирование заявки
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String ItemId = this.input.ask("Введите Id заявки для редактирования");
        Item editedItem = this.tracker.findById(ItemId);
        if (editedItem != null) {
            System.out.println("Редактируем заявку: " + editedItem);
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            item.setId(editedItem.getId());
            this.tracker.replace(ItemId, item);
            System.out.println("------------ Заявка с Id : " + ItemId + " обновлена-----------");
            System.out.println(this.tracker.findById(ItemId));
        } else {
            System.out.println("------------ Заявка с Id : " + ItemId + " не найдена-----------");
        }
    }

    /**
     * Метод реализует удаление заявки
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String itemId = this.input.ask("Введите Id заявки для удаленя");
        Item deleteItem = this.tracker.findById(itemId);
        if (deleteItem != null) {
            this.tracker.delete(itemId);
            System.out.println("------------ Заявка с Id : " + itemId + " удалена-----------");
        } else {
            System.out.println("------------ Заявка с Id : " + itemId + " не найдена-----------");
        }
    }

    /**
     * Метод реализует поиск заявки по Id
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ID--------------");
        String itemId = this.input.ask("Введите Id заявки для поиска");
        Item foundItem = this.tracker.findById(itemId);
        if (foundItem != null) {
            System.out.println(foundItem);
        } else {
            System.out.println("------------ Заявка с Id : " + itemId + " не найдена-----------");
        }
    }

    /**
     * Метод реализует поиск заявок по имени
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени--------------");
        String name = this.input.ask("Введите иня заявки для поиска");
        Item[] foundItem = this.tracker.findByName(name);
        if (foundItem.length > 0) {
            Arrays.stream(foundItem).forEach(System.out::println);
        } else {
            System.out.println("------------ Заявок с именем : " + name + " не найдены-----------");
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
