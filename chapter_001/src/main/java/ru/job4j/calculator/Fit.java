package ru.job4j.calculator;

/**
 * The program of calculation of ideal weight.
 */
public class Fit {
    /**
     * Ideal weight for men.
     * @param height height.
     * @return weight.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Ideal weight for woman.
     * @param height height.
     * @return weight.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}