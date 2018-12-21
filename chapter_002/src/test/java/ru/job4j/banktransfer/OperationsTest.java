package ru.job4j.banktransfer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *
 */
public class OperationsTest {
    private Operations operations = new Operations();
    private User user = new User("Victor", "12345");

    @Test
    public void whenAddUser() {
        operations.addUser(user);
        assertTrue(operations.getUserAccount().containsKey(user));
    }
    @Test
    public void whenDeleteUser() {
        operations.addUser(user);
        operations.deleteUser(user);
        assertFalse(operations.getUserAccount().containsKey(user));
    }
    @Test
    public void whenAddAccountToUser() {
        operations.addUser(user);
        operations.addAccountToUser("12345", new Account(50, "11A11"));
        assertThat(operations.getUserAccount().get(user).get(0).getRequisites(), is("11A11"));
    }
    @Test
    public void whenDeleteAccountFromUser() {
        operations.addUser(user);
        Account account =  new Account(50, "11A11");
        Account account1 = new Account(100, "12A11");
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        operations.deleteAccountFromUser("12345", account);
        assertThat(operations.getUserAccount().get(user).get(0).getRequisites(), is("12A11"));
    }
    @Test
    public void whenGetUserAccountThenListOfAccount() {
        operations.addUser(user);
        Account account =  new Account(50, "11A11");
        Account account1 = new Account(100, "12A11");
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        List<Account> result = operations.getUserAccounts("12345");
        List<Account> expect = Arrays.asList(account, account1);
        assertThat(result, is(expect));
    }
    @Test
    public void whenTransferMoney() {
        operations.addUser(user);
        Account account =  new Account(50, "11A11");
        Account account1 = new Account(100, "12A11");
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        operations.transferMoney("12345", "12A11", "12345", "11A11", 10);
        assertThat(operations.getUserAccount().get(user).get(0).getValue(), is(60));
    }
}
