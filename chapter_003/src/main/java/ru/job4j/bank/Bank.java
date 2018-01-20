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
     * Get User by his passport
     *
     * @param passport - passport of User
     * @return - User
     * @throws UserNotFoundInBankException if there is no User with this passport
     */
    public User getUserByPassport(String passport) throws UserNotFoundInBankException {
        User resultUser = null;
        for (Map.Entry<User, List<Account>> entry : this.usersAccounts.entrySet()
                ) {
            if (entry.getKey().getPassport().equals(passport)) {
                resultUser = entry.getKey();
                break;
            }
        }
        if (resultUser == null) {
            throw new UserNotFoundInBankException("User with passport: " + passport + " not found");
        }
        return resultUser;
    }

    /**
     * Get User Account from his accounts list
     *
     * @param allUserAccounts - Users accounts list
     * @param requisite       - account number
     * @return - Account
     * @throws UserAccountNotFoundException is there is no Account with this requisite
     */
    public Account getUserAccountFromListByRequisite(List<Account> allUserAccounts, String requisite) throws UserAccountNotFoundException {
        Account resultAccount = null;
        for (Account account : allUserAccounts
                ) {
            if (account.getRequisites().equals(requisite)) {
                resultAccount = account;
                break;
            }
        }
        if (resultAccount == null) {
            throw new UserAccountNotFoundException("Account not found");
        }
        return resultAccount;
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
     * @throws UserNotFoundInBankException
     */
    public void addAccountToUser(String passport, Account account) throws UserNotFoundInBankException {
        User user = getUserByPassport(passport);
        this.usersAccounts.get(user).add(account);
    }

    /**
     * Delete Users account
     *
     * @param passport - Users passport
     * @param account  - Account to delete
     * @throws UserNotFoundInBankException
     */
    public void deleteAccountFromUser(String passport, Account account) throws UserNotFoundInBankException {
        User user = getUserByPassport(passport);
        this.usersAccounts.get(user).remove(account);
    }

    /**
     * Get list of all Users Accounts
     *
     * @param passport - Users passport
     * @return - List of accounts
     * @throws UserNotFoundInBankException
     */
    public List<Account> getAllUserAccounts(String passport) throws UserNotFoundInBankException {
        return this.usersAccounts.get(getUserByPassport(passport));
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
     * @throws UserNotFoundInBankException
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) throws UserNotFoundInBankException {
        try {
            return getUserAccountFromListByRequisite(getAllUserAccounts(srcPassport), srcRequisite).
                    transferMoney(getUserAccountFromListByRequisite(getAllUserAccounts(destPassport), destRequisite), amount);
        } catch (UserAccountNotFoundException e) {
            return false;
        }
    }
}
