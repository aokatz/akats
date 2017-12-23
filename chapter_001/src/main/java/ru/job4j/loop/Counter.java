package ru.job4j.loop;

/**
 * Сумма четных чисел от start до finish
 * @author AKats
 */
public class Counter {
    /**
     * Сумма четных чисел от start до finish
     * @param start - старт
     * @param finish - финиш
     * @return - сумма четных от старта до финиша
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
