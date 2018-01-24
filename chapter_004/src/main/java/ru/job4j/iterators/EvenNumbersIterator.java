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
    private int next = -1;
    private boolean hasNextEven = false;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                this.next = i;
                this.hasNextEven = true;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return this.hasNextEven;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            int res = this.numbers[next];
            this.hasNextEven = false;
            for (int i = this.next + 1; i < this.numbers.length; i++) {
                if (this.numbers[i] % 2 == 0) {
                    this.next = i;
                    this.hasNextEven = true;
                    break;
                }
            }
            return res;
        } else {
            throw new NoSuchElementException();
        }
    }
}
