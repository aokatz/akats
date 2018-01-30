package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple list of T type elements
 *
 * @param <T> - type of elements
 * @author AKats
 */
public class SimpleLinkedList<T> implements Iterable<T> {

    class Node<E> {
        E elem;
        private Node<E> next;
        private Node<E> prev;

        public Node(E elem, Node<E> next, Node<E> prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size = 0;
    private int modCount = 0;
    private Node<T> last = null;

    public void add(T elem) {
        Node l = this.last;
        Node<T> newNode = new Node<>(elem, null, this.last);
        if (l != null) {
            l.next = newNode;
        }
        this.last = newNode;
        this.size++;
        this.modCount++;
    }

    public T get(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> x = this.last;
        for (int i = this.size - 1; i > index; i--) {
            x = x.prev;
        }
        return x.elem;
    }

    public void del(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> x = this.last;
        for (int i = this.size - 1; i > index; i--) {
            x = x.prev;
        }
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            if (x.next != null) {
                x.next.prev = null;
            }
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.elem = null;
        size--;
        modCount++;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = this.get(i);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return get(current++);
            }
        };
    }

}
