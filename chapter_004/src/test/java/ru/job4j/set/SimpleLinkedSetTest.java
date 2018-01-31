package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedSetTest {

    @Test
    public void whenAddShouldAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        assertThat(set.iterator().next(), is(1));
    }

}