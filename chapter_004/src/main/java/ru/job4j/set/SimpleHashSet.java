package ru.job4j.set;

import java.util.Arrays;

/**
 * SimpleHashSet class. Hash set based on array.
 *
 * @param <T> - type of elements in set
 */
public class SimpleHashSet<T> {
    private int tableSize;
    private int elementsCount = 0;
    private Object[] hashTable;

    public SimpleHashSet(int tableSize) {
        this.tableSize = tableSize;
        hashTable = new Object[tableSize];
    }

    public SimpleHashSet() {
        this(128);
    }

    private void resizeTable() {
        Object[] oldHashTable = Arrays.copyOf(this.hashTable, this.hashTable.length);
        this.tableSize *= 2;
        this.hashTable = new Object[this.tableSize];
        this.elementsCount = 0;
        for (Object elem : oldHashTable) {
            putElementInTable((T) elem);
        }
    }

    private void putElementInTable(T e) {
        int elementHash = e.hashCode() % this.tableSize;
        if (this.hashTable[elementHash] == null) {
            this.elementsCount++;
        }
        this.hashTable[elementHash] = e;
    }

    public boolean add(T e) {
        if (this.elementsCount == this.tableSize) {
            this.resizeTable();
        }
        this.putElementInTable(e);
        return true;
    }

    public boolean contains(T e) {
        return this.hashTable[e.hashCode() % this.tableSize] != null;
    }

    public boolean remove(T e) {
        boolean res = this.contains(e);
        if (res) {
            this.hashTable[e.hashCode() % this.tableSize] = null;
            this.elementsCount--;
        }
        return res;
    }
}
