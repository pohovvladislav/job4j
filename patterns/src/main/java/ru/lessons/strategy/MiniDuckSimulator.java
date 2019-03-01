package ru.lessons.strategy;

import ru.lessons.strategy.flight.FlyRocketPowered;
import ru.lessons.strategy.model.Duck;
import ru.lessons.strategy.model.MallardDuck;
import ru.lessons.strategy.model.ModelDuck;

/**
 *
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        ModelDuck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
