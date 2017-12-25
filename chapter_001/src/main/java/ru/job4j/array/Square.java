package ru.job4j.array;

/**
 * Создание массива с квадратами индексов с 1
 * @author AKats
 */
public class Square {
    /**
     * Создание массива с квадратами индексов с 1
     * @param bound размер массива
     * @return массив с квадратами индексов с 1 в качестве значений
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = i * i;
        }
        return result;
    }
}