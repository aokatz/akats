package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test Counter
 * @author AKats
 */
public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        assertThat(counter.add(1, 10), is(30));
    }
}