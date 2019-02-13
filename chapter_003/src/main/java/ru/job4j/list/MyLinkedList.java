package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class realises LinkedList.
 * @author В-87.
 * @param <E>
 */
public class MyLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private Node<E> first;
    private int modCount = 0;

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E value) {
            this.date = value;
        }
    }

    /**
     * The method adds an element to the sheet.
     * @param value Element.
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }

    /**
     * The method of finding the element at index.
     * @param index Index.
     * @return Element.
     */
    public E get(int index) {
        if (index > this.size) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private Node<E> result = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (index != 0) {
                    result = result.next;
                }
                index++;
                return result.date;
            }
        };
    }
}
