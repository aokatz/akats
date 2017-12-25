package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void testSort() {
        int[] resultArray = {5, 1, 2, 7, 3};
        int[] expectArray = {1, 2, 3, 5, 7};
        assertThat(new BubbleSort().sort(resultArray), is(expectArray));
    }

}