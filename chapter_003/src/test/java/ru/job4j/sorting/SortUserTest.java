package ru.job4j.sorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {

    /**
     * Тестирование преобразования листа в сет
     */
    @Test
    public void whenSortListGetSortedSet() {
        SortUser sortUser = new SortUser();
        List<User> usersList = Arrays.asList(
                new User("name1", 10),
                new User("name2", 2),
                new User("name3", 15)
        );
        TreeSet<User> usersSet = new TreeSet<>();
        usersSet.add(new User("name1", 10));
        usersSet.add(new User("name2", 2));
        usersSet.add(new User("name3", 15));
        Set<User> sortedSet = sortUser.sort(usersList);
        List<Integer> sortedList = new ArrayList<>();
        Iterator<User> it = sortedSet.iterator();
        while (it.hasNext()) {
            User next = it.next();
            sortedList.add(next.getAge());
        }
        List<Integer> sortedTargetList = Arrays.asList(2, 10, 15);
        assertThat(sortedList, is(sortedTargetList));
    }

    /**
     * Тестирование сортировки по возрасту
     */
    @Test
    public void whenSortByAgeThenGetSortedList() {
        SortUser sortUser = new SortUser();
        List<User> unsortedList = Arrays.asList(
                new User("name1", 10),
                new User("name123", 2),
                new User("name12", 15)
        );
        List<User> sortedList = Arrays.asList(
                new User("name1", 10),
                new User("name12", 15),
                new User("name123", 2)
        );
        assertThat(sortedList, is(sortUser.sortNameLength(unsortedList)));
    }

    /**
     * Тестирование сортировки по имени а потом по возрасту
     */
    @Test
    public void whenSortByAllFieldsThenGetSortedList() {
        SortUser sortUser = new SortUser();
        List<User> userList = Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );
        sortUser.sortByAllFields(userList);
        assertThat(userList.get(0), is(new User("Иван", 25)));
    }

}