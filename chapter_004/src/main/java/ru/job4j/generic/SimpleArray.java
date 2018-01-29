package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;


/**
 * Simple array of T type elements
 *
 * @param <T> - type of elements
 * @author AKats
 */
public class SimpleArray<T> implements Iterable<T> {
    private int index = 0;
    private Object[] array;

    public SimpleArray() {
        array = new Object[0];
    }

    public Object[] getArray() {
        return array;
    }

    private void checkArrayLength() {
        if (this.index + 1 > this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
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

            @Override
            public boolean hasNext() {
                return current < index;
            }

            @Override
            public T next() {
                return (T) array[current++];
            }
        };
    }
}
