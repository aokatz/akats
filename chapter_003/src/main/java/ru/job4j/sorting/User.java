package ru.job4j.sorting;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static int compareByNameThenByAge(User u1, User u2) {
        if (u1.name.equals(u2.name)) {
            return u1.age - u2.age;
        } else {
            return u1.name.compareTo(u2.name);
        }
    }

    @Override
    public int compareTo(User o) {
        return this.getAge().compareTo(o.getAge());
    }

    @Override
    public String toString() {
        return "[Name = " + this.getName() + " Age = " + this.getAge() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
