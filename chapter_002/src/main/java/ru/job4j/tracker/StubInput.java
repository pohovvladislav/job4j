package ru.job4j.tracker;

import java.util.List;

/**
 * Класс имитирует поведение пользователя.
 */
public class StubInput implements Input {
    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Выход за пределы списка!");
        }
    }
}
