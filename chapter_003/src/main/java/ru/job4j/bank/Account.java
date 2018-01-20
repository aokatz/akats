package ru.job4j.bank;

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
}
