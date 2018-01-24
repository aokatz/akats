package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for two dimensions array
 *
 * @author AKats
 */
public class TwoDimensionArraysIterator implements Iterator<Integer> {

    private int[][] ints;
    int i = 0;
    int j = 0;

    public TwoDimensionArraysIterator(int[][] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return (i < ints.length);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            Integer res = ints[i][j];
            if (j + 1 < ints[i].length) {
                j++;
            } else {
                i++;
                j = 0;
            }
            return res;
        }
    }
}
