package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * Сравнение списков Integer по сумме элементов
 * @author AKats
 */
public class ListCompare implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        return Integer.compare(left.stream().mapToInt(Integer::intValue).sum(), right.stream().mapToInt(Integer::intValue).sum());
    }
}