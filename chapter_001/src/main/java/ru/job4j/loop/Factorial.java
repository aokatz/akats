package ru.job4j.loop;

/**
 * Вычисление факториала
 * @author AKats
 */
public class Factorial {
    /**
     * Вычисление факториала
     * @param n - число для вычисления факториала
     * @return - факториал n
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
