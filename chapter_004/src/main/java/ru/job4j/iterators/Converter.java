package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Convert Iterator<Iterator<Integer>> to Iterator<Integer>
 *
 * @author AKats
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {
            Iterator<Integer> curIt = its.next();

            @Override
            public boolean hasNext() {
                while (its.hasNext()) {
                    if (!this.curIt.hasNext()) {
                        this.curIt = its.next();
                    } else {
                        break;
                    }
                }
                return this.curIt.hasNext() || its.hasNext();
            }

            @Override
            public Integer next() {
                Integer res;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    if (this.curIt.hasNext()) {
                        res = this.curIt.next();
                    } else {
                        this.curIt = its.next();
                        res = this.curIt.next();
                    }
                }
                return res;
            }
        };
    }
}
