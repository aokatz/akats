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

    private int nextEvenPosition(int position) {
        int res = -1;
        for (int i = position; i < this.numbers.length; i++) {
            if (this.numbers[i] % 2 == 0) {
                res = i;
                break;
            }
        }
        return res;
    }

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
        this.next = nextEvenPosition(0);
    }

    @Override
    public boolean hasNext() {
        return this.next != -1;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            int res = this.numbers[this.next];
            this.next = this.nextEvenPosition(this.next + 1);
            return res;
        }
    }
}
