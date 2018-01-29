package ru.job4j.generic;

/**
 * Base abstract class
 *
 * @author AKats
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}