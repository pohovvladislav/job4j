package ru.job4j.calculator;

/**
 * Calculator.
 * @author Popov Vladislav (mailto:navodbmd.2@mail.ru).
 */

public class Calculator {
    private double result;

    /**
     * The method performs addition.
     * @param first number.
     * @param second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * The method performs subtraction.
     * @param first number.
     * @param second number.
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }

    /**
     * The method performs division.
     * @param first number.
     * @param second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * The method performs multiplies.
     * @param first number.
     * @param second number.
     */
    public void mult(double first, double second) {
        this.result = first * second;
    }

    /**
     * result reading method.
     * @return result
     */

    public double getResult() {
        return this.result;
    }
}