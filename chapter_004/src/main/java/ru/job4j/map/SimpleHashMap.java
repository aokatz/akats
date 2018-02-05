package ru.job4j.map;


import java.util.Arrays;

/**
 * SimpleHashMap class. Hash set based on array.
 *
 * @param <K> - key type
 * @param <V> - value type
 */
public class SimpleHashMap<K, V> {
    private int elementsCount = 0;
    private Node<K, V>[] hashTable;

    class Node<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public SimpleHashMap(int tableSize) {
        hashTable = new Node[tableSize];
    }

    public SimpleHashMap() {
        this(128);
    }

    private void resizeTable() {
        Node<K, V>[] oldHashTable = this.hashTable;
        this.hashTable = new Node[this.hashTable.length * 2];
        this.elementsCount = 0;
        for (Node<K, V> elem : oldHashTable) {
            putElementInTable(elem.getKey(), elem.getValue());
        }
    }

    private int getHash(Object o) {
        return (o.hashCode() ^ 2) % this.hashTable.length;
    }

    private boolean putElementInTable(K key, V value) {
        boolean res = false;
        int elementHash = getHash(key);
        if (this.hashTable[elementHash] == null) {
            this.elementsCount++;
            this.hashTable[elementHash] = new Node(key, value);
            res = true;
        }
        return res;
    }

    public boolean insert(K key, V value) {
        if (this.elementsCount == this.hashTable.length) {
            this.resizeTable();
        }
        this.putElementInTable(key, value);
        return true;
    }

    public boolean contains(K e) {
        return this.hashTable[getHash(e)] != null;
    }

    public V get(K key) {
        return this.hashTable[getHash(key)].getValue();
    }

    public boolean delete(K e) {
        boolean res = this.contains(e);
        if (res) {
            this.hashTable[getHash(e)] = null;
            this.elementsCount--;
        }
        return res;
    }
}
