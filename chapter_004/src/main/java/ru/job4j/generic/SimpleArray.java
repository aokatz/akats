package ru.job4j.generic;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;


/**
 * Simple array of T type elements
 *
 * @param <T> - type of elements
 * @author AKats
 */
public class SimpleArray<T> implements Iterable<T> {
    private int modCount = 0;
    private int index = 0;
    private Object[] array;

    public SimpleArray() {
        array = new Object[10];
    }

    public Object[] getArray() {
        return array;
    }

    private void checkArrayLength() {
        if (this.index + 1 > this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length * 2);
            this.modCount++;
        }
    }

    public void add(T model) {
        checkArrayLength();
        this.array[index++] = model;
    }

    public void set(int index, T model) {
        this.array[index] = model;
    }

    public void delete(int index) {
        Object[] res = new Object[this.array.length - 1];
        this.index--;
        for (int i = 0, j = 0; j < res.length; i++, j++) {
            if (i == index) {
                ++i;
            }
            res[j] = this.array[i];
        }
        this.array = res;
    }

    public T get(int index) {
        return (T) this.array[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return current < index;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) array[current++];
            }
        };
    }
}
