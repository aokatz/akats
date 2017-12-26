package ru.job4j.array;

/**
 * Переворачиваем массив
 * @author AKats
 */
public class Turn {
    /**
     * Переворачиваем массив
     * @param array - массив
     * @return - перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int swich = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = swich;
        }
        return array;
    }
}
