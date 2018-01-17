package ru.job4j.tracker.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOuput() {
        System.setOut(stdout);
    }

    /**
     * Тест вывода всех заявок
     */
    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "description"));
        Input input = new StubInput(Arrays.asList("1", "6"));
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню:")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Отображение всех заявок --------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("id: ")
                                .append(item.getId())
                                .append(System.lineSeparator())
                                .append("name: name")
                                .append(System.lineSeparator())
                                .append("description: description")
                                .append(System.lineSeparator())
                                .append("created: 0")
                                .append(System.lineSeparator())
                                .append("comments: null")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("-----------------------")
                                .append(System.lineSeparator())
                                .append("Меню:")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );

    }


    /**
     * Тест добавления заявки
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(Arrays.asList("0", "test name", "desc", "6"));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Тест обновления заявки
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(Arrays.asList("2", item.getId(), "test name", "desc", "6"));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Тест удаления заявки
     */
    @Test
    public void whenDeleteThenDeleteElement() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "descriptiontest1", 1);
        Item second = new Item("test2", "descriptiontest2", 2);
        tracker.add(first);
        tracker.add(second);
        Input input = new StubInput(Arrays.asList("3", second.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(first));
    }

}