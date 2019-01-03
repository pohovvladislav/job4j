package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *@version $Id$
 *@since 0.1
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean working = true;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show(output);
            menu.select(input.ask("выберите :", range));

        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
