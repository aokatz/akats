package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for two dimensions array
 *
 * @author AKats
 */
public class TwoDimensionArraysIterator implements Iterator<Integer> {

    private int[][] arrayToIterate;
    int i = 0;
    int j = 0;

    public TwoDimensionArraysIterator(int[][] arrayToIterate) {
        this.arrayToIterate = arrayToIterate;
    }

    @Override
    public boolean hasNext() {
        return (i < arrayToIterate.length);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Integer res = arrayToIterate[i][j];
            if (j + 1 < arrayToIterate[i].length) {
                j++;
            } else {
                i++;
                j = 0;
            }
            return res;
        } else {
            throw new NoSuchElementException();
        }
    }
}
