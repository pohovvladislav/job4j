package ru.lessons.strategy.sounds;

import ru.lessons.strategy.interfaces.QuackBehavior;

/**
 * The class implements the behavior.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
