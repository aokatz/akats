package ru.job4j.bank;

import java.util.Objects;

/**
 * Account class
 *
 * @author AKats
 */
public class Account {
    //amount of money
    private double value;
    //account number
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    /**
     * Transfer amount of money from this account to destination account
     *
     * @param destination - destination account
     * @param amount      - amount to transfer
     * @return - false in case of insufficient amount, else true
     */
    public boolean transferMoney(Account destination, double amount) {
        boolean result = false;
        if (this.getValue() > amount) {
            this.setValue(this.getValue() - amount);
            destination.setValue(destination.getValue() + amount);
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {

        return Objects.hash(requisites);
    }
}
