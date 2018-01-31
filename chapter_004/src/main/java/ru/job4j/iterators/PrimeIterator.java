package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Prime numbers iterator
 *
 * @author AKats
 */
public class PrimeIterator implements Iterator {

    private final int[] numbers;
    private int next;


    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    private boolean isPrime(int n) {
        boolean res = true;
        if (n == 1 || n % 2 == 0) {
            res = false;
        }
        if (n == 2) {
            res = true;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = this.next; i < this.numbers.length; i++) {
            if (isPrime(this.numbers[i])) {
                this.next = i;
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return this.numbers[this.next++];
    }
}
