package ru.job4j.collection.tree;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <E>
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    List<Node<E>> leaves() {
        return this.children;
    }

    boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }

    E getValue() {
        return this.value;
    }
}
