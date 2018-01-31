package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

import java.util.Iterator;


/**
 * SimpleLinkedSet class. Set over the SimpleLinkedList class.
 *
 * @param <T> - type of elements in set
 */
public class SimpleLinkedSet<T> implements Iterable {
    private SimpleLinkedList<T> set = new SimpleLinkedList<>();

    private boolean contains(T e) {
        boolean res = false;
        for (T element : this.set) {
            if (element.equals(e)) {
                res = true;
                break;
            }
        }
        return res;
    }


    public void add(T e) {
        if (!contains(e)) {
            this.set.add(e);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return this.set.iterator();
    }
}
