package ru.lessons.strategy.sounds;

import ru.lessons.strategy.interfaces.QuackBehavior;

/**
 * The class implements the behavior.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
