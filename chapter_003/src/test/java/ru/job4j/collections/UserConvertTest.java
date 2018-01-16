package ru.job4j.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    /**
     * Тест преобразования листа в карту
     */
    @Test
    public void whenProcessListOfUsersThenGetMapOfUsers() {
        List<User> listOfUsers = Arrays.asList(
                new User(1, "User1", "City1"),
                new User(2, "User2", "City2"),
                new User(3, "User3", "City3")
        );
        HashMap<Integer, User> mapOfUsers = new HashMap<>();
        mapOfUsers.put(1, new User(1, "User1", "City1"));
        mapOfUsers.put(2, new User(2, "User2", "City2"));
        mapOfUsers.put(3, new User(3, "User3", "City3"));
        assertThat(UserConvert.process(listOfUsers), is(mapOfUsers));
    }
}