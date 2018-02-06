package ru.job4j.set;

import java.util.Arrays;

/**
 * SimpleHashSet class. Hash set based on array.
 *
 * @param <T> - type of elements in set
 */
public class SimpleHashSet<T> {
    private int elementsCount = 0;
    private Object[] hashTable;

    public SimpleHashSet(int tableSize) {
        hashTable = new Object[tableSize];
    }

    public SimpleHashSet() {
        this(128);
    }

    private int getHash(Object o) {
        return (o.hashCode() ^ 2) % this.hashTable.length;
    }

    private void resizeTable() {
        Object[] oldHashTable = this.hashTable;
        this.hashTable = new Object[this.hashTable.length * 2];
        this.elementsCount = 0;
        for (Object elem : oldHashTable) {
            putElementInTable((T) elem);
        }
    }

    private void putElementInTable(T e) {
        int elementHash = getHash(e);
        if (this.hashTable[elementHash] == null) {
            this.elementsCount++;
        }
        this.hashTable[elementHash] = e;
    }

    public boolean add(T e) {
        if (this.elementsCount == this.hashTable.length) {
            this.resizeTable();
        }
        this.putElementInTable(e);
        return true;
    }

    public boolean contains(T e) {
        return this.hashTable[getHash(e)] != null;
    }

    public boolean remove(T e) {
        boolean res = this.contains(e);
        if (res) {
            this.hashTable[getHash(e)] = null;
            this.elementsCount--;
        }
        return res;
    }
}
