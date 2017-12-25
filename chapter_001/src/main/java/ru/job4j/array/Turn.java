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
        int swich = 0;
        for (int i = 0; i < array.length / 2; i++) {
            swich = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = swich;
        }
        return array;
    }
}
