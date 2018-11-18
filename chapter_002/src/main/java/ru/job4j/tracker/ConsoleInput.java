package ru.job4j.tracker;
/**
 * A class for entering user data from the console.
 */

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
            }
        }
        if (!exist) {
            throw new MenuOutException("Выход за пределы списка!");
        }
        return key;
    }
}
