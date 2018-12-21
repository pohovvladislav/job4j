package ru.job4j.banktransfer;

/**
 * The class describes the customer's Bank account.
 */
public class Account {
    private int value;
    private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
