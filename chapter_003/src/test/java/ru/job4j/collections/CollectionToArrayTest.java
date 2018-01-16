package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CollectionToArrayTest {
    /**
     * Тест преобразования массива в список
     */
    @Test
    public void wenListToArraythenGetArray() {
        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, 0));
        int[][] expectedArray = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(CollectionToArray.toArray(integerList, 3), is(expectedArray));
    }

    /**
     * Тест преобразования списка в массив
     */
    @Test
    public void wenArrayToListthenGetList() {
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, 0));
        int[][] intArray = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(CollectionToArray.toList(intArray), is(expectedList));
    }
}