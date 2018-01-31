package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Even numbers iterator
 *
 * @author AKats
 */
public class EvenNumbersIterator implements Iterator {

    private final int[] numbers;
    private int next;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        for (int i = next; i < this.numbers.length; i++) {
            if (this.numbers[i] % 2 == 0) {
                next = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return numbers[next++];
        }
    }
}
