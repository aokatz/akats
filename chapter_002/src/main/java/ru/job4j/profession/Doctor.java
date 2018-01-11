package ru.job4j.profession;

public class Doctor extends Person {
    private Diploma diploma;
    private String specialization;

    public Diagnose heal(Person patent) {
        return new Diagnose();
    }
}
