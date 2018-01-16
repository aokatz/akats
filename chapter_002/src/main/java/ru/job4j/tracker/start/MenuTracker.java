package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Arrays;

/**
 * Класс отображения всех жлементов
 */
class ShowAllItems extends BaseAction {
    public ShowAllItems(String name) {
        super(name);
    }

    @Override
    public void executeSelectedAction(Input input, Tracker tracker) {
        System.out.println("------------ Отображение всех заявок --------------");
        Arrays.stream(tracker.findAll()).forEach(System.out::println);
        System.out.println("-----------------------");
    }
}

/**
 * Класс вывода и работы с меню
 *
 * @author AKats
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int[] allowedRange = {0, 1, 2, 3, 4, 5, 6};
    private boolean exitProgramFlag = false;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        initMenu();
    }

    public boolean isExitProgramm() {
        return this.exitProgramFlag;
    }

    /**
     * Заполнение массива действий пользователяшо объектами-действиями внутренних классов
     */
    private void initMenu() {
        this.actions[0] = this.new AddNewItem("0. Add new Item");
        this.actions[1] = new ShowAllItems("1. Show all items");
        this.actions[2] = new MenuTracker.EditItem("2. Edit item");
        this.actions[3] = new DeleteItem("3. Delete item");
        this.actions[4] = new FindItemById("4. Find item by Id");
        this.actions[5] = new FindItemByName("5. Find items by name");
        this.actions[6] = new ExitProgram("6. Exit Program");
    }


    /**
     * Выполнение действия объекта в массиве объектов-действий
     *
     * @param actionKey - ключь в массиве объектов-действий
     */
    private void executeAction(int actionKey) {
        this.actions[actionKey].executeSelectedAction(this.input, this.tracker);
    }

    /**
     * Вывод меню
     *
     * @return - true при выходе пользователя из меню
     */
    public void showMenu() {
        System.out.println("Меню:");
        for (UserAction action : actions) {
            System.out.println(action.getActionTitle());
        }
    }

    /**
     * Обработка деействий пользователя
     *
     * @return - true при выходе пользователя из меню
     */
    public void execAction() {
        int answer = this.input.ask("Введите пункт меню : ", this.allowedRange);
        this.executeAction(Integer.valueOf(answer));
    }

    /**
     * Класс обработки события выхода
     */
    public class ExitProgram extends BaseAction {

        public ExitProgram(String name) {
            super(name);
        }

        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            exitProgramFlag = true;
        }
    }

    /**
     * Класс добавления элемента
     */
    private class AddNewItem extends BaseAction {

        public AddNewItem(String name) {
            super(name);
        }

        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
        }
    }

    /**
     * Класс редактирования элемента
     */
    private static class EditItem extends BaseAction {

        public EditItem(String name) {
            super(name);
        }

        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String itemId = input.ask("Введите Id заявки для редактирования");
            Item editedItem = tracker.findById(itemId);
            if (editedItem != null) {
                System.out.println("Редактируем заявку: " + editedItem);
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание заявки :");
                Item item = new Item(name, desc);
                item.setId(editedItem.getId());
                tracker.replace(itemId, item);
                System.out.println("------------ Заявка с Id : " + itemId + " обновлена-----------");
                System.out.println(tracker.findById(itemId));
            } else {
                System.out.println("------------ Заявка с Id : " + itemId + " не найдена-----------");
            }
        }
    }

    /**
     * Класс удаления элемента
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(String name) {
            super(name);
        }

        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String itemId = input.ask("Введите Id заявки для удаленя");
            Item deleteItem = tracker.findById(itemId);
            if (deleteItem != null) {
                tracker.delete(itemId);
                System.out.println("------------ Заявка с Id : " + itemId + " удалена-----------");
            } else {
                System.out.println("------------ Заявка с Id : " + itemId + " не найдена-----------");
            }
        }
    }

    /**
     * Класс поиска элемента по Id
     */
    private class FindItemById extends BaseAction {
        public FindItemById(String name) {
            super(name);
        }

        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID--------------");
            String itemId = input.ask("Введите Id заявки для поиска");
            Item foundItem = tracker.findById(itemId);
            if (foundItem != null) {
                System.out.println(foundItem);
            } else {
                System.out.println("------------ Заявка с Id : " + itemId + " не найдена-----------");
            }
        }
    }

    /**
     * Класс поиска элемента по имени.
     */
    private class FindItemByName extends BaseAction {
        public FindItemByName(String name) {
            super(name);
        }

        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени--------------");
            String name = input.ask("Введите иня заявки для поиска");
            Item[] foundItem = tracker.findByName(name);
            if (foundItem.length > 0) {
                Arrays.stream(foundItem).forEach(System.out::println);
            } else {
                System.out.println("------------ Заявки с именем : " + name + " не найдены-----------");
            }
        }
    }

}
