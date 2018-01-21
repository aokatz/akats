package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank(new HashMap<>());
        User user = new User("name", "passport123");
        bank.addUser(user);
        Map<User, List<Account>> expectedAccounts = new HashMap<>();
        expectedAccounts.put(user, new ArrayList<>());
        assertThat(bank.getUsersAccounts(), is(expectedAccounts));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank(new HashMap<>());
        User user1 = new User("name", "passport123");
        User user2 = new User("name2", "passport321");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user1);
        Map<User, List<Account>> expectedAccounts = new HashMap<>();
        expectedAccounts.put(user2, new ArrayList<>());
        assertThat(bank.getUsersAccounts(), is(expectedAccounts));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank(new HashMap<>());
        User user = new User("name", "passport123");
        Account account = new Account(100, "405905");
        bank.addUser(user);
        bank.addAccountToUser("passport123", account);
        Map<User, List<Account>> expectedAccounts = new HashMap<>();
        List<Account> expectedAccount = new ArrayList<>();
        expectedAccount.add(account);
        expectedAccounts.put(user, expectedAccount);
        assertThat(bank.getUsersAccounts(), is(expectedAccounts));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank(new HashMap<>());
        User user = new User("name", "passport123");
        Account account1 = new Account(100, "1");
        Account account2 = new Account(50, "2");
        bank.addUser(user);
        bank.addAccountToUser("passport123", account1);
        bank.addAccountToUser("passport123", account2);
        bank.deleteAccountFromUser("passport123", account2);
        Map<User, List<Account>> expectedAccounts = new HashMap<>();
        expectedAccounts.put(user, Arrays.asList(account1));
        assertThat(bank.getUsersAccounts(), is(expectedAccounts));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank(new HashMap<>());
        User user1 = new User("name", "passport1");
        User user2 = new User("name", "passport2");
        Account account1 = new Account(100, "account1");
        Account account2 = new Account(50, "account2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport2", account2);
        bank.transferMoney("passport1", "account1", "passport2", "account2", 50);
        assertThat(bank.getUserAccounts("passport2").get(0).getValue(), is(100.0));
    }

    @Test
    public void whenTransferMoneyAndNotEnoughAmount() {
        Bank bank = new Bank(new HashMap<>());
        User user1 = new User("name", "passport1");
        User user2 = new User("name", "passport2");
        Account account1 = new Account(100, "account1");
        Account account2 = new Account(50, "account2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport2", account2);
        assertThat(bank.transferMoney("passport1", "account1", "passport2", "account2", 500), is(false));
    }

    @Test
    public void whenTransferMoneyAndNotFoundAccount() {
        Bank bank = new Bank(new HashMap<>());
        User user1 = new User("name", "passport1");
        User user2 = new User("name", "passport2");
        Account account2 = new Account(50, "account2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("passport2", account2);
        assertThat(bank.transferMoney("passport1", "account12", "passport2", "account2", 500), is(false));
    }
}