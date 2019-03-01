package ru.lessons.strategy.flight;

import ru.lessons.strategy.interfaces.FlyBehavior;

/**
 * The class implements the behavior.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
