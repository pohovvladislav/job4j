package ru.job4j.collection.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Обертка для массива.
 */
public class SimpleArray<T> implements Iterable<T> {
    private  T[] array;
    private int index = 0;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        this.array[index++] = model;
    }

    public void set(int index, T model) {
        if (this.index >= index) {
            this.array[index] = model;
        } else {
            throw new IndexOutOfBoundsException("эл-та с таким индексом не существует");
        }
    }

    public void remove(int index) {
        if (this.index >= index) {
            System.arraycopy(this.array, index + 1, this.array, index,
                    this.array.length - index - 1
            );
            this.index--;
        } else {
            throw new IndexOutOfBoundsException("эл-та с таким индексом не существует");
        }
    }

    public T get(int index) {
        if (this.index <= index) {
            throw new IndexOutOfBoundsException("эл-та с таким индексом не существует");
        }
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int r = 0;
            @Override
            public boolean hasNext() {
                return index > r;
            }
            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[r++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
