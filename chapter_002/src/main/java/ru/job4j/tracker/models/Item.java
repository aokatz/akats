package ru.job4j.tracker.models;

import java.util.Arrays;

/**
 * Класс Заявка
 *
 * @author AKats
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    private String[] comments;

    public Item() {

    }

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return newLine + "id: " + this.getId() + newLine
                + "name: " + this.getName() + newLine
                + "description: " + this.getDescription() + newLine
                + "created: " + this.getCreated() + newLine
                + "comments: " + Arrays.toString(this.getComments()) + newLine;
    }
}
