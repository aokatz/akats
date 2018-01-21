package ru.job4j.bank;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Bank class. Repository of Users Accounts
 *
 * @author AKats
 */
public class Bank {
    private Map<User, List<Account>> usersAccounts;

    public Bank(Map<User, List<Account>> usersAccounts) {
        this.usersAccounts = usersAccounts;
    }

    public Map<User, List<Account>> getUsersAccounts() {
        return usersAccounts;
    }


    /**
     * Add User
     *
     * @param user - User to add
     */
    public void addUser(User user) {
        this.usersAccounts.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Delete User
     *
     * @param user - User to delete
     */
    public void deleteUser(User user) {
        this.usersAccounts.remove(user);
    }

    /**
     * Adds Account to User accounts list
     *
     * @param passport - Passport of User
     * @param account  - Account to add
     */
    public void addAccountToUser(String passport, Account account) {
        this.usersAccounts.get(new User("", passport)).add(account);
    }

    /**
     * Delete Users account
     *
     * @param passport - Users passport
     * @param account  - Account to delete
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.usersAccounts.get(new User("", passport)).remove(account);
    }

    /**
     * Get list of all Users Accounts
     *
     * @param passport - Users passport
     * @return - List of accounts
     */
    public List<Account> getUserAccounts(String passport) {
        return this.usersAccounts.get(new User("", passport));
    }

    /**
     * Transfer amount of money from one account to another
     *
     * @param srcPassport   - Source users passport
     * @param srcRequisite  - Source account number
     * @param destPassport  - Destination users passport
     * @param destRequisite - Destination account number
     * @param amount        - amount to transfer
     * @return - false in case of insufficient amount or inability to find accounts numbers, else true
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        List<Account> srcUserAccounts = this.usersAccounts.get(new User("", srcPassport));
        List<Account> destUserAccounts = this.usersAccounts.get(new User("", destPassport));
        boolean res = false;
        if (srcUserAccounts != null
                && destUserAccounts != null
                && srcUserAccounts.indexOf(new Account(0.0, srcRequisite)) != -1
                && destUserAccounts.indexOf(new Account(0.0, destRequisite)) != -1) {
            Account srcAccount = srcUserAccounts.get(srcUserAccounts.indexOf(new Account(0.0, srcRequisite)));
            Account destAccount = destUserAccounts.get(destUserAccounts.indexOf(new Account(0.0, destRequisite)));
            res = srcAccount.transferMoney(destAccount, amount);
        }
        return res;
    }
}
