package ru.job4j.array;

/**
 * Двухмерный массив. Таблица умножения.
 * @author AKats
 */
public class Matrix {
    /**
     * Построение матрицы умножением индексов
     * @param size - размер матрицы
     * @return - заполненная матрица
     */
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
        return result;
    }
}
