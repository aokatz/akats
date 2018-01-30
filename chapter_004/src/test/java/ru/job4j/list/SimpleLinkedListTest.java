package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();

    @Before
    public void setUp() {
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
    }

    @Test
    public void whenAddElementShouldAdd() {
        assertThat(simpleLinkedList.toArray(), is(new Integer[]{1, 2, 3}));
    }

    @Test
    public void whenGetElementShouldGetIt() {
        assertThat(simpleLinkedList.get(0), is(1));
    }

}