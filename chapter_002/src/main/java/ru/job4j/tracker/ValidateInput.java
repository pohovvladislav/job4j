package ru.job4j.tracker;

import java.util.List;

/**
 * Класс проверки ввода данных меню.
 */
public class ValidateInput extends ConsoleInput {

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста, выберите пункт меню!");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите номер пункта из списка.");
            }
        } while (invalid);
        return value;
    }
}

