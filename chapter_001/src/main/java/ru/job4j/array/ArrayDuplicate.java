package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов из массива
 * @author AKats
 */
public class ArrayDuplicate {
    /**
     * Удаление дубликатов из массива
     * @param array - массив
     * @return - новый массисв без дубликатов
     */
    public String[] remove(String[] array) {
        int dublicateCount = 0;
        int uniqLength = array.length;
        for (int i = 0; i < uniqLength - 1; i++) {
            for (int j = i + 1; j < uniqLength; j++) {
                if (array[i].equals(array[j]))  {
                    for (int k = j; k < uniqLength - 1; k++) {
                        String swap = array[k];
                        array[k] = array[k + 1];
                        array[k + 1] = swap;
                    }
                    uniqLength--;
                    dublicateCount++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dublicateCount);
    }
}
