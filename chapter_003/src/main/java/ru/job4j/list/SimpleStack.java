package ru.job4j.list;

/**
 * Реализация стека на базе связного списка.
 * @param <T>
 */
public class SimpleStack<T> {
    private SimpleArrayList<T> list;

    public SimpleStack(SimpleArrayList<T> list) {
        this.list = list;
    }

    /**
     * Метод достает объект из стека.
     * @return объект.
     */
    public T pop() {
        return list.delete();
    }

    /**
     * Метод добавляет объект в стек.
     * @param value Объект.
     */
    public void push(T value) {
        list.add(value);
    }
}
