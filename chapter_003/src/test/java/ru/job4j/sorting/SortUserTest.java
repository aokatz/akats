package ru.job4j.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {

    /**
     * Тестирование преобразования листа в сет
     */
    @Test
    public void whenSortListGetSortedSet() {
        List<User> usersList = Arrays.asList(
                new User("name1", 10),
                new User("name2", 2),
                new User("name3", 15)
        );
        TreeSet<User> usersSet = new TreeSet<>();
        usersSet.add(new User("name1", 10));
        usersSet.add(new User("name2", 2));
        usersSet.add(new User("name3", 15));
        assertThat(usersSet, is(SortUser.sort(usersList)));
    }
}