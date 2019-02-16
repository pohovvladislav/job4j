package ru.job4j.list;

/**
 * Класс реализует очередь на двух стеках.
 */
public class SimpleQueue<T> {
    private SimpleStack<T> stack1 = new SimpleStack<>();
    private SimpleStack<T> stack2 = new SimpleStack<>();

    /**
     * Метод перемещает элементы из одного стека в другой
     */
    private void transfer() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    /**
     * Метод достает первый элемент из очереди.
     * @return Элемент.
     */
    public T poll() {
        if (stack2.isEmpty()) {
            this.transfer();
        }
        return stack2.pop();
    }

    /**
     * Метод добавляет элемент в очередь.
     * @param value Элемент.
     */
    public void push(T value) {
        stack1.push(value);
    }
}
