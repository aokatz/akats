package ru.job4j.binarysearchtree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void whenAddElements() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(50);
        tree.add(10);
        tree.add(15);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(15));
        assertThat(it.next(), is(50));
    }

}