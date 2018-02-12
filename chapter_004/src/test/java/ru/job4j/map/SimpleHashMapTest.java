package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenAddElementShouldAdd() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        for (int i = 0; i < 5; i++) {
            hashMap.insert(i, "i=" + i);
        }
        assertThat(hashMap.get(4), is("i=4"));
    }

    @Test
    public void whenRemove() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        for (int i = 0; i < 5; i++) {
            hashMap.insert(i, "i=" + i);
        }
        hashMap.delete(3);
        assertThat(hashMap.contains(3), is(false));
    }

}