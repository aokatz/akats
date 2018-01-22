package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MergeSortedArraysTest {

    @Test
    public void whenMergeArraysThanGetMergeArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 16};
        int[] b = {6, 7, 8, 9, 10, 11, 12};
        int[] res = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9, 10, 11, 12, 16};
        assertThat(MergeSortedArrays.mergeArrays(a, b), is(res));
    }
}