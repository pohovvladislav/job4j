package ru.job4j.banktransfer;

/**
 * The class describes the customer's Bank account.
 */
public class Account {
    private double value;
    private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
