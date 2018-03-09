package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = this.findBy(parent);
        Optional<Node<E>> childNode = this.findBy(child);
        if (parentNode.isPresent() && !childNode.isPresent()) {
            parentNode.get().add(new Node<>(child));
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> elements = new LinkedList<>(Arrays.asList(root));

            @Override
            public boolean hasNext() {
                return !elements.isEmpty();
            }

            @Override
            public E next() {
                Node<E> res = this.elements.poll();
                elements.addAll(res.leaves());
                return res.getValue();
            }
        };
    }

    private boolean isBinary(Node<E> node) {
        boolean res = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(node);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                res = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return res;
    }

    public boolean isBinary() {
        return isBinary(this.root);
    }

}
