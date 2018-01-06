package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.Tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerTest {

    /**
     * Test добавления элемента     *
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test замены элемента
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test удаление элемента
     */
    @Test
    public void whenDeleteThenDeleteElement() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "descriptiontest1", 1);
        Item second = new Item("test2", "descriptiontest2", 2);
        tracker.add(first);
        tracker.add(second);
        tracker.delete(second.getId());
        assertThat(tracker.findById(first.getId()), is(first));
    }
    /**
     * Test поиск эдемента по id
     */
    @Test
    public void whenFindByIdItemThenFindThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
    /**
     * Test поиск эдемента по name
     */
    @Test
    public void whenFindByNameItemThenFindThoseItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test","testDescription1",1);
        Item second = new Item("test","testDescription2",2);
        Item third = new Item("test1","testDescription3",3);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] result = {first, second};
        assertThat(tracker.findByName("test"), is(result));
    }
    /**
     * Test список всех заявок
     */
    @Test
    public void whenFindAllItemsThenFindThoseItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test","testDescription1",1);
        Item second = new Item("test","testDescription2",2);
        Item third = new Item("test1","testDescription3",3);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] result ={first, second, third};
        assertThat(tracker.findAll(), is(result));
    }

}