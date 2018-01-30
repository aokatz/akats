package ru.job4j.list;

/**
 * Simple queue of T type elements
 *
 * @param <T> - type of elements
 * @author AKats
 */
public class SimpleQueue<T> {
    private SimpleLinkedList<T> list = new SimpleLinkedList<>();

    public void push(T value) {
        list.add(value);
    }

    public T poll() {
        T res = this.list.get(0);
        list.del(0);
        return res;
    }
}
