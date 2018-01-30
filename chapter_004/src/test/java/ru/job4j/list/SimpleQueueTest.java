package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void whenPushthenPullShouldGetFirst() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }


}