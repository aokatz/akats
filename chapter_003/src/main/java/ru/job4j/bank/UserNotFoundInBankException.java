package ru.job4j.bank;

public class UserNotFoundInBankException extends Exception {
    public UserNotFoundInBankException(String message) {
        super(message);
    }
}
