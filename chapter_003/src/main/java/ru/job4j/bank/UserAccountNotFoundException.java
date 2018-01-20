package ru.job4j.bank;

public class UserAccountNotFoundException extends Exception {
    public UserAccountNotFoundException(String message) {
        super(message);
    }
}
