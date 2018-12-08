package ru.job4j.task;

import java.util.Arrays;

/**
 * @author Popov Vladislav.
 * @version 1.0.
 * @since 1.0.
 */
public class CoffeeMachine {
    public static final int[] NOMINALVALUE = {10, 5, 2, 1};
    /**
     * The method counts a delivery.
     * @param value Banknote.
     * @param price Price for coffee.
     * @return Delivery.
     */
    public int[] changes(int value, int price) {
        int coins = 0;
        int[] delivery = new int[value];
        int delNumb = value - price;
        if (delNumb > 0) {
            for (int elem : NOMINALVALUE) {
                if (delNumb / elem > 0) {
                    int count = (int) Math.floor((double) delNumb / elem);
                    delNumb -= elem * count;
                    coins += count;
                    for (int i = coins - count; i < coins; i++) {
                        delivery[i] = elem;
                    }
                }
            }
        } else if (delNumb == 0) {
            System.out.println(" ");
        } else {
            System.out.println("Недостаточно средств для покупки!");
            System.out.println("Внесите еще :" + " " + (price - value) + " руб.");
        }

        return Arrays.copyOf(delivery, coins);
    }
}
