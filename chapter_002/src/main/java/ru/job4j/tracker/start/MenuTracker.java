package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Arrays;

/**
 * Класс отображения всех жлементов
 */
class ShowAllItems implements UserAction {
    @Override
    public void executeSelectedAction(Input input, Tracker tracker) {
        System.out.println("------------ Отображение всех заявок --------------");
        Arrays.stream(tracker.findAll()).forEach(System.out::println);
        System.out.println("-----------------------");
    }

    @Override
    public String getActionTitle() {
        return "1. Show all items";
    }
}

/**
 * Класс вывода и работы с меню
 * @author AKats
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        initMenu();
    }

    /**
     * Заполнение массива действий пользователяшо объектами-действиями внутренних классов
     */
    private void initMenu() {
        this.actions[0] = this.new AddNewItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
    }

    /**
     * Выполнение действия объекта в массиве объектов-действий
     * @param actionKey - ключь в массиве объектов-действий
     */
    private void executeAction(int actionKey) {
        this.actions[actionKey].executeSelectedAction(this.input, this.tracker);
    }

    /**
     * Вывод меню и обработка деействий пользователя
     * @return - true при выходе пользователя из меню
     */
    public boolean showMenuExecAction() {
        boolean res = false;
        System.out.println("Меню:");
        for (UserAction action: actions
             ) {
            System.out.println(action.getActionTitle());
        }
        System.out.println("6. Exit Program");
        String answer = this.input.ask("Введите пункт меню : ");
        if (Integer.valueOf(answer) >= 0 && Integer.valueOf(answer) <= 5) {
            this.executeAction(Integer.valueOf(answer));
        } else {
            res = true;
        }
        return res;
    }

    /**
     * Класс добавления элемента
     */
    private class AddNewItem implements UserAction {
        @Override
        public void executeSelectedAction(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
        }

        @Override
        public String getActionTitle() {
            return "0. Add new Item";
        }
    }

    /**
     * Класс редактирования элемента
     */
    private static class EditItem implements UserAction {
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

        @Override
        public String getActionTitle() {
            return "2. Edit item";
        }
    }

    /**
     * Класс удаления элемента
     */
    private class DeleteItem implements UserAction {
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

        @Override
        public String getActionTitle() {
            return "3. Delete item";
        }
    }

    /**
     * Класс поиска элемента по Id
     */
    private class FindItemById implements UserAction {
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

        @Override
        public String getActionTitle() {
            return "4. Find item by Id";
        }
    }

    /**
     * Класс поиска элемента по имени.
     */
    private class FindItemByName implements UserAction {
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

        @Override
        public String getActionTitle() {
            return "5. Find items by name";
        }
    }

}
