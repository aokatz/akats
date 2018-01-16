package ru.job4j.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Преобразование списка в двумерный массив и обратно
 *
 * @author AKats
 */
public class CollectionToArray {

    /**
     * Массив в список
     *
     * @param array - массив
     * @return - список
     */
    public static List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    /**
     * Список в двумерный массив с добавление нулей
     * список (1,2,3,4,5,6,7) с разбиением на 3 строки должен получиться двумерный массив {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
     *
     * @param list - список
     * @param rows - количество строк
     * @return - двумерный массив
     */
    public static int[][] toArray(List<Integer> list, int rows) {
        int[][] result = new int[rows][(int) Math.ceil(list.size() / (double) rows)];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (int) Math.ceil(list.size() / (double) rows); j++) {
                result[i][j] = iterator.hasNext() ? iterator.next() : 0;
            }
        }
        return result;
    }

}
