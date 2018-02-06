package ru.job4j.binarysearchtree;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTreeIterator<E extends Comparable<E>> implements Iterator {
    Stack<Node<E>> elements = new Stack<>();

    public BinaryTreeIterator(Node<E> root) {
        fillStack(root);
    }

    public void fillStack(Node<E> root) {
        while (root != null) {
            elements.push(root);
            root = root.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        return !elements.isEmpty();
    }

    @Override
    public E next() {
        Node<E> result = elements.pop();
        fillStack(result.getRight());
        return result.getValue();
    }
}
