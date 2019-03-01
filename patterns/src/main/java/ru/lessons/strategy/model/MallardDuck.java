package ru.lessons.strategy.model;

import ru.lessons.strategy.flight.FlyWithWings;
import ru.lessons.strategy.sounds.Quack;

/**
 *
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
