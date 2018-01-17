package ru.job4j.sorting;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * Сортировки
 *
 * @author AKats
 */
public class SortUser {

    /**
     * Преобразование листа в TreeSet сет
     *
     * @param users - лист
     * @return - сет
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<User>(users);
    }

    /**
     * Сортировка списка User по длине имени
     *
     * @param users - список User
     * @return - отсортированый список User
     */
    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    /**
     * Сортировка списка User по имени а потом по возрасту
     *
     * @param users - список User
     * @return - отсортированный список User
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(User::compareByNameThenByAge);
        return users;
    }

}

