package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertListTest {
    /**
     * Тест преобразования список массивов в список
     */
    @Test
    public void whenConvertListOfArraysThenGetList() {
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2});
        listOfArrays.add(new int[]{3, 4, 5, 6});
        assertThat(ConvertList.convert(listOfArrays), is(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    /**
     * Тест преобразования массива в список
     */
    @Test
    public void whenListToArraythenGetArray() {
        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, 0));
        int[][] expectedArray = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(ConvertList.toArray(integerList, 3), is(expectedArray));
    }

    /**
     * Тест преобразования списка в массив
     */
    @Test
    public void whenArrayToListthenGetList() {
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, 0));
        int[][] intArray = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(ConvertList.toList(intArray), is(expectedList));
    }
}