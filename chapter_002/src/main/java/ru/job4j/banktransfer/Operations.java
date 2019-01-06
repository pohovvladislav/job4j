package ru.job4j.banktransfer;

import java.util.*;

/**
 * The class describes banking operations.
 */
public class Operations {
    private Map<User, List<Account>> userAccount = new HashMap<>();


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
    public Optional<User> getUserByPassport(String passport) {
        return this.userAccount.keySet().stream().filter(key -> key.getPassport().equals(passport)).findFirst();
    }
    /**
     * The method of adding an invoice to the user.
     * @param passport User passport.
     * @param account New account of user.
     */
    public void addAccountToUser(String passport, Account account) {
        if (this.getUserByPassport(passport).isPresent()) {
            User user =  this.getUserByPassport(passport).get();
            this.userAccount.get(user).add(account);
        }
    }

    /**
     * The method deletes one user account.
     * @param passport User passport.
     * @param account Account of user.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        if (this.getUserByPassport(passport).isPresent()) {
            User user =  this.getUserByPassport(passport).get();
            this.userAccount.get(user).remove(account);
        }
    }

    /**
     * The method gets a list of accounts for the user.
     * @param passport User passport.
     * @return List of accounts for the user.
     */
    public Optional<List<Account>> getUserAccounts(String passport) {
        Optional<User> user = this.getUserByPassport(passport);
        Optional<List<Account>> accounts = Optional.empty();
        if (user.isPresent()) {
            accounts = Optional.of(this.userAccount.get(user.get()));
        }
        return accounts;
    }

    /**
     * The method finds the user's account on the passport.
     * @param passport User's passport.
     * @param requisite Account's requisite.
     * @return User's account.
     */
    public  Optional <Account> getAccountByRequisiteFromUserPassport(String passport, String requisite) {
        Optional<Account> accountReq = Optional.empty();
        Optional<List<Account>> userAccounts = getUserAccounts(passport);
        if (userAccounts.isPresent()) {
            accountReq = userAccounts.get().stream().filter(account -> account.getRequisites()
                    .equals(requisite)).findFirst();
        }
        return accountReq;
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
        if (this.getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite).isPresent()
                && this.getAccountByRequisiteFromUserPassport(destPassport, destRequisite).isPresent()) {
            result = this.getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite).get().transfer(
                    this.getAccountByRequisiteFromUserPassport(destPassport, destRequisite).get(), amount
            );
        }
        return result;
    }
}
