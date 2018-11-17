package ru.job4j.tracker;
/**
 * A class for entering user data from the console.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    boolean exist = false;
  /**  private final List<Consumer<Input>> validates = Arrays.asList(
            input -> {
                if (!exist) {
                    throw new MenuOutException("Выход за пределы списка!");
                }
            }
    );
*/

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    public int ask(String question, List<Integer> range) {

        int key = Integer.valueOf(this.ask(question));

        for (int value : range) {
            if (value == key) {
                exist = true;
            }
        }

       // this.validates.forEach(action -> action.accept(???));
        if (!exist) {
            throw new MenuOutException("Выход за пределы списка!");
        }
        return key;
    }
}
