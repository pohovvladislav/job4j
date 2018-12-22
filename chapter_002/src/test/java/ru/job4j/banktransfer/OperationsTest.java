package ru.job4j.banktransfer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 */
public class OperationsTest {
    private Operations operations = new Operations();
    private User user = new User("Victor", "12345");
    private Account account =  new Account(50, "11A11");
    private Account account1 = new Account(100, "12A11");

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
    public void whenGetUserByPassportThenUser() {
        operations.addUser(user);
        assertThat(operations.getUserByPassport("12345"), is(user));
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
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        operations.deleteAccountFromUser("12345", account);
        assertThat(operations.getUserAccount().get(user).get(0).getRequisites(), is("12A11"));
    }
    @Test
    public void whenGetUserAccountThenListOfAccount() {
        operations.addUser(user);
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        assertThat(operations.getUserAccounts("12345"), is(Arrays.asList(account, account1)));
    }
    @Test
    public void whenTransferMoney() {
        operations.addUser(user);
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        assertTrue(operations.transfer(account, account1, 18));
    }

    @Test
    public void whenTransferMoneyBetweenUsers() {
        operations.addUser(user);
        operations.addAccountToUser("12345", account);
        operations.addAccountToUser("12345", account1);
        assertTrue(operations.transferMoney("12345", "12A11", "12345", "11A11", 18));
    }
}
