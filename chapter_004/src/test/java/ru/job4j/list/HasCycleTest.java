package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HasCycleTest {

    @Test
    public void whenHaveLoopShouldFindIt() {
        HasCycle hasCycle = new HasCycle();
        HasCycle.Node<Integer> first = hasCycle.new Node<>(1);
        HasCycle.Node<Integer> two = hasCycle.new Node<>(2);
        HasCycle.Node<Integer> third = hasCycle.new Node<>(3);
        HasCycle.Node<Integer> four = hasCycle.new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(hasCycle.hasCycle(first), is(true));
    }

}