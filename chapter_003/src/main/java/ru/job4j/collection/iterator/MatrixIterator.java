package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор двумерного массива.
 */
public class MatrixIterator implements Iterator {

    private final int[][] array;
    private int row = 0;
    private int cell = 0;

    public MatrixIterator(final int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return row < array.length;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int result = array[row][cell++];
        if (cell == array[row].length) {
            cell = 0;
            row++;
        }
        return result;
    }
}
