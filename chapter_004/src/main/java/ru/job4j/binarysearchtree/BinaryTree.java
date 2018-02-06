package ru.job4j.binarysearchtree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Binary search tree
 *
 * @param <E> - type of elements
 * @author AKats
 */
public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {
    private Node<E> root = null;


    private void addElem(Node<E> root, Node<E> newNode) {
        if (root == null) {
            this.root = newNode;
            return;
        }
        if (newNode.compareTo(root.getValue()) > 0) {
            if (root.getRight() == null) {
                root.setRight(newNode);
            } else {
                addElem(root.getRight(), newNode);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
            } else {
                addElem(root.getLeft(), newNode);
            }
        }
    }

    public void add(E value) {
        this.addElem(this.root, new Node<>(value));
    }

    @Override
    public Iterator<E> iterator() {
        return new BinaryTreeIterator<E>(this.root);
    }
}
