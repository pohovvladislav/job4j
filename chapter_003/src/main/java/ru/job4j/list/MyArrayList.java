package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class realises ArrayList.
 * @author В-87
 * @param <E>
 */
public class MyArrayList<E> implements Iterable<E> {
    private int firstLength = 2;
    private Object[] container = new Object[firstLength];
    private int index = 0;
    private int modCount = 0;

    public MyArrayList() {
    }

    public MyArrayList(int length) {
        this.firstLength = length;
    }

    /**
     * The method adds an element to the sheet.
     * @param value Element.
     */
    public void add(E value) {
        if (this.index >= this.firstLength) {
            this.container = Arrays.copyOf(this.container, this.firstLength * 2);
        }
        container[index++] = value;
        modCount++;
    }

    /**
     * The method of finding the element at index.
     * @param index Index.
     * @return Element.
     */
    public E get(int index) {
        if (index > this.index) {
            throw new NoSuchElementException();
        }
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return this.count < index;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Список изменен!");
                }
                return (E) container[this.count++];
            }
        };
    }
}

