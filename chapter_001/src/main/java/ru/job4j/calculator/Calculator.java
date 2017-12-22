package ru.job4j.calculator;

/**
 * Класс Calculator. Консольный калькулятор. Реализует методы сложения, вычитания, деления и умножения.
 * @author akats
 * @version 1
 * @since 21.12.17
 */
public class Calculator {
    private double result;

    /**
     * Метод сложения
     * @param first - первое слагаемое
     * @param second - второе слагаемое
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Метод вычитания
     * @param first - число, из которого вычитаем
     * @param second - число, которое вычитаем
     */
    public void substruct(double first, double second) {
        this.result = first - second;
    }
    /**
     * Метод деления
     * @param first - частное
     * @param second - делитель
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Метод умножения
     * @param first - первое число, которое умножаем
     * @param second - второе число. которое умножаем
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {
        return this.result;
    }
}
