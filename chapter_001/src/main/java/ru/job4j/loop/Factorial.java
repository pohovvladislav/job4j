package ru.job4j.loop;

/**
 * @author Popov Vladislav.
 */
public class Factorial {
    /**
     * Method to calculate factorial.
     * @param n Number.
     * @return Factorial n.
     */
    public int calc(int n) {
        int result = 1;
        if (n == 0) {
            return result;
        }
        for (int count = 1; count <= n; count++) {
            result *= count;
        }
        return result;
    }
}