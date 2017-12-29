package ru.job4j.array;

/**
 * Сортировка пузырьком
 * @author AKats
 */
public class BubbleSort {
    /**
     * Сортировка пузырьком
     * @param array - неотсортированный массив
     * @return - отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int swich = array[i];
                    array[i] = array[j];
                    array[j] = swich;
                }
            }
        }
        return array;
    }
}
