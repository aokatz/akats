package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class UserMap. Demo for Map using
 *
 * @author AKats
 */
public class UserMap {
    public static void main(String[] args) {
        User user1 = new User("name1", 1, new GregorianCalendar(1982, 10, 06));
        User user2 = new User("name1", 1, new GregorianCalendar(1982, 10, 06));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
}
