package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import java.util.Arrays;

public class StartUI {

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
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        do {
            menuTracker.showMenu();
            menuTracker.execAction();
        } while (!menuTracker.isExitProgramm());

    }


    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
