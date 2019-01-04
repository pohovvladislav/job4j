package ru.job4j.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Account> list =  this.getUserAccounts(passport).stream().filter(account ->
                account.getRequisites().equals(requisite)).collect(Collectors.toList());
        for (Account account : list)
            accountReq = account;
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
        return this.getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite).transfer(
                this.getAccountByRequisiteFromUserPassport(destPassport, destRequisite), amount
        );
    }
}
