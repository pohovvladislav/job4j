package ru.job4j.task;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * The test of CoffeeMachine program.
 */
public class CoffeeMachineTest {
    @Test
    public void whenDelivery15ThenCoins2() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(50, 35);
        int[] expect = {10, 5};
        assertThat(result, is(expect));
    }
}
