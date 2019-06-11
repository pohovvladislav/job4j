package ru.job4j.collection.tree;

import java.util.Optional;

/**
 * @param <E>
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return true or false, в зависимости от результата.
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
