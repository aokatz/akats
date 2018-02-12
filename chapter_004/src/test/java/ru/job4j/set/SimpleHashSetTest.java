package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashSetTest {

    @Test
    public void whenAddElementShouldAdd() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>();
        for (int i = 0; i < 5; i++) {
            hashSet.add(i);
        }
        assertThat(hashSet.contains(4), is(true));
    }

    @Test
    public void whenRemove() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>();
        for (int i = 0; i < 5; i++) {
            hashSet.add(i);
        }
        hashSet.remove(3);
        assertThat(hashSet.contains(3), is(false));
    }

}