package ru.job4j.list;

/**
 * Simple stack of T type elements
 *
 * @param <T> - type of elements
 * @author AKats
 */
public class SimpleStack<T> {
    private SimpleLinkedList<T> list = new SimpleLinkedList<>();
    private int size = 0;

    public void push(T value) {
        list.add(value);
        size++;
    }

    public T poll() {
        T res = this.list.get(this.size);
        list.del(size);
        size--;
        return res;
    }
}
