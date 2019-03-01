package ru.lessons.strategy.flight;

import ru.lessons.strategy.interfaces.FlyBehavior;

/**
 * The class implements the behavior.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
