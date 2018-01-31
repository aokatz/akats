package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

/**
 * SimpleSet class. Set over the SimpleArray class.
 *
 * @param <T> - type of elements in set
 */
public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> set = new SimpleArray<>();

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
