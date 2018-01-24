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
    private int next = -1;
    private boolean hasNextPrime = false;

    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
        for (int i = 0; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                this.next = i;
                this.hasNextPrime = true;
                break;
            }
        }
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
        return this.hasNextPrime;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            int res = this.numbers[next];
            this.hasNextPrime = false;
            for (int i = this.next + 1; i < this.numbers.length; i++) {
                if (isPrime(numbers[i])) {
                    this.next = i;
                    this.hasNextPrime = true;
                    break;
                }
            }
            return res;
        } else {
            throw new NoSuchElementException();
        }
    }
}
