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
     * The method finds the user's passport.
     * @param passport User's passport.
     * @return User.
     */
    public User getUserByPassport(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : this.userAccount.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                user = key;
                break;
            }
        }
        return user;
    }
    /**
     * The method of adding an invoice to the user.
     * @param passport User passport.
     * @param account New account of user.
     */
    public void addAccountToUser(String passport, Account account) {
        this.userAccount.get(this.getUserByPassport(passport)).add(account);
    }

    /**
     * The method deletes one user account.
     * @param passport User passport.
     * @param account Account of user.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.userAccount.get(this.getUserByPassport(passport)).remove(account);
    }

    /**
     * The method gets a list of accounts for the user.
     * @param passport User passport.
     * @return List of accounts for the user.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userAccount.get(this.getUserByPassport(passport));
    }

    /**
     * The method finds the user's account on the passport.
     * @param passport User's passport.
     * @param requisite Account's requisite.
     * @return User's account.
     */
    public Account getAccountByRequisiteFromUserPassport(String passport, String requisite) {
        Account accountReq = null;
        for (Account account : this.getUserAccounts(passport)) {
            if (account.getRequisites().equals(requisite)) {
                accountReq = account;
            }
        }
        return accountReq;
    }

    /**
     * The method for transferring money from one account to another.
     * @param srcAccount The account of the sender.
     * @param destAccount Beneficiary's account.
     * @param amount Amount.
     * @return Result.
     */
    public boolean transfer(Account srcAccount, Account destAccount, double amount) {
        boolean result = false;
        if (srcAccount != null && destAccount != null && amount <= srcAccount.getValue() && amount > 0
                && srcAccount != destAccount) {
            result = true;
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
        }
        return result;
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
        return this.transfer(this.getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite),
                this.getAccountByRequisiteFromUserPassport(destPassport, destRequisite), amount);
    }
}
