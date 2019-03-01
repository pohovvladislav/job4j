package ru.lessons.strategy.model;


import ru.lessons.strategy.flight.FlyNoWay;
import ru.lessons.strategy.sounds.Quack;

/**
 *
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm model duck");
    }
}
