package ru.job4j.tracker.start;

public interface UserAction {
    void executeSelectedAction(Input input, Tracker tracker);
    String getActionTitle();
}
