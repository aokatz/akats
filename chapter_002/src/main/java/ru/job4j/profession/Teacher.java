package ru.job4j.profession;

public class Teacher extends Person {
    private Diploma diploma;
    private String specialization;

    public Knoledge teach(Person student) {
        return new Knoledge();
    }
}
