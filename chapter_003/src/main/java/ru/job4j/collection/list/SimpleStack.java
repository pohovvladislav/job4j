package ru.job4j.collection.list;

/**
 * Реализация стека на базе связного списка.
 * @param <T>
 */
public class SimpleStack<T> {
    private SimpleList<T> list = new SimpleList<>();
    private int count = 0;

    /**
     * Метод достает объект из стека.
     * @return объект.
     */
    public T pop() {
        count--;
        return list.delete();
    }

    /**
     * Метод добавляет объект в стек.
     * @param value Объект.
     */
    public void push(T value) {
        list.add(value);
        count++;
    }

    /**
     * Метод проверяет пуст ли стек.
     * @return Результат проверки.
     */
    public boolean isEmpty() {
        boolean result = false;
        if (count == 0) {
            result = true;
        }
        return result;
    }
}
