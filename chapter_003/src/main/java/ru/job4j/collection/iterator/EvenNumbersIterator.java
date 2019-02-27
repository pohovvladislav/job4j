package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор четных чисел.
 */
public class EvenNumbersIterator implements Iterator {
    private final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean checker = false;
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] == 0 || numbers[i] % 2 == 0) {
                checker = true;
                index = i;
                break;
            }
        }
        return checker;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
