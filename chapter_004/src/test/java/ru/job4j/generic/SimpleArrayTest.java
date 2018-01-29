package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>();
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
    }

    @Test
    public void whenAddElementShouldAdd() {
        assertThat(simpleArray.getArray(), is(new Integer[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void whenSetElementShouldReplaceIt() {
        simpleArray.set(3, 10);
        assertThat(simpleArray.getArray(), is(new Integer[]{1, 2, 3, 10, 5}));
    }

    @Test
    public void whenDeleteShouldDelete() {
        simpleArray.delete(3);
        assertThat(simpleArray.getArray(), is(new Integer[]{1, 2, 3, 5}));
    }

    @Test
    public void whenGetElementShouldGetIt() {
        assertThat(simpleArray.get(0), is(1));
    }

    @Test
    public void shouldReturnElementsUsingIterator() {
        int i = 0;
        for (Integer elem: simpleArray
             ) {
            assertThat(elem, is(simpleArray.get(i++)));
        }
    }
}