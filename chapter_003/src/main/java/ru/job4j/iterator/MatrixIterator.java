package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор двумерного массива.
 */
public class MatrixIterator implements Iterator {

    private int[][] array;
    private int row = 0;
    private int cell = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return !(row == array.length - 1 && cell == array[row].length) && array.length != 0;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (cell == array[row].length) {
            cell = 0;
            row++;
        }
        return array[row][cell++];
    }
}
