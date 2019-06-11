package ru.job4j.collection.set;

import ru.job4j.collection.list.SimpleList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация коллекции Set.
 * @param <E>
 */
public class SimpleSet<E> implements Iterable<E> {
    private SimpleList<E> list = new SimpleList<>();
    private int size = 0;

    /**
     * Метод добавляет элементы в коллекцию.
     * @param e Элемент.
     */
    public void add(E e) {
        if (this.size == 0 || !this.check(e)) {
            this.list.add(e);
            this.size++;
        }
    }

    /**
     * Метод проверяет есть ли уже такой элемент в коллекции.
     * @param e Элемент.
     * @return Результат.
     */
    private boolean check(E e) {
        boolean result = false;
        for (int i = 0; i < this.list.getSize(); i++) {
            if (this.list.get(i).equals(e)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return this.count < size;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return list.get(this.count++);
            }
        };
    }
}
