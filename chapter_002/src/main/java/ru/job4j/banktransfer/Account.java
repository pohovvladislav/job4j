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

    /**
     * The method for transferring money from one account to another.
     * @param destAccount Beneficiary's account.
     * @param amount Amount.
     * @return Result.
     */
    public boolean transfer(Account destAccount, double amount) {
        boolean result = false;
        if (destAccount != null && amount <= this.value && amount > 0 && this != destAccount) {
            result = true;
            this.value -= amount;
            destAccount.value += amount;
        }
        return result;
    }
}
