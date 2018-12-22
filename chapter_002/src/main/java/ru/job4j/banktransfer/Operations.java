package ru.job4j.banktransfer;

import java.util.*;

/**
 * The class describes banking operations.
 */
public class Operations {
    private Map<User, List<Account>> userAccount = new TreeMap<>();


    public Map<User, List<Account>> getUserAccount() {
        return this.userAccount;
    }

    /**
     * The method of adding a user.
     * @param user User.
     */
    public void addUser(User user) {
        this.userAccount.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Client removal method.
     * @param user User.
     */
    public void deleteUser(User user) {
        this.userAccount.remove(user);
    }

    /**
     * The method of adding an invoice to the user.
     * @param passport User passport.
     * @param account New account of user.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.userAccount.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                this.userAccount.get(user).add(account);
                break;
            }
        }
    }

    /**
     * The method deletes one user account.
     * @param passport User passport.
     * @param account Account of user.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.userAccount.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                entry.getValue().remove(account);
                break;
            }
        }
    }

    /**
     * The method gets a list of accounts for the user.
     * @param passport User passport.
     * @return List of accounts for the user.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : this.userAccount.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                list = entry.getValue();
                break;
            }
        }
        return list;
    }

    /**
     * The method for transferring money from one account to another.
     * @param srcPassport The passport of the sender.
     * @param srcRequisite The details of the sender.
     * @param destPassport Beneficiary's passport.
     * @param destRequisite Details of the recipient.
     * @param amount Amount.
     * @return Result.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
                                  String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = null;
        Account destAccount = null;
        for (Map.Entry<User, List<Account>> entry : this.userAccount.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(srcPassport)) {
                for (Account account : entry.getValue()) {
                    if (account.getRequisites().equals(srcRequisite)) {
                        srcAccount = account;
                    }
                }
            }
            if (user.getPassport().equals(destPassport)) {
                for (Account account : entry.getValue()) {
                    if (account.getRequisites().equals(destRequisite)) {
                        destAccount = account;
                    }
                }
            }
            if (srcAccount != null && destAccount != null) {
                break;
            }
        }
        if (srcAccount != null && destAccount != null && amount <= srcAccount.getValue() && amount > 0
                && srcAccount != destAccount) {
            result = true;
            srcAccount.setValue((int) (srcAccount.getValue() - amount));
            destAccount.setValue((int) (destAccount.getValue() + amount));
        }
        return result;
    }
}
