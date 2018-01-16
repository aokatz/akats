package ru.job4j.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Класс пользователь
 */
class User {
    private Integer id;
    private String name;
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(name, user.name)
                && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, city);
    }

    public Integer getId() {
        return id;
    }

    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}

/**
 * Преобразование List пользователей в Map id пользователя на пользователя
 * @author AKats
 */
public class UserConvert {
    public static HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        list.forEach(user -> result.put(user.getId(), user));
        return result;

    }
}
