package ru.job4j.tracker.start;

public abstract class BaseAction implements UserAction {
    private String name;

    public BaseAction(String name) {
        this.name = name;
    }

    @Override
    public String getActionTitle() {
        return this.name;
    }
}
