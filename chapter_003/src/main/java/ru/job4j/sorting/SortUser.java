package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Преобразование листа в сет
 *
 * @author AKats
 */
public class SortUser {
    public static Set<User> sort(List<User> users) {
        return new TreeSet<User>(users);
    }
}
