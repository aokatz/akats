package ru.job4j.sorting;

public class User implements Comparable<User> {
    private String name;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    private Integer age;

    @Override
    public int compareTo(User o) {
        return o.getAge().compareTo(this.getAge());
    }
}
