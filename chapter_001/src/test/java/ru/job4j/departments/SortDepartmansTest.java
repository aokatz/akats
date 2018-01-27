package ru.job4j.departments;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class SortDepartmansTest {

    @Test
    public void whenSortThenGetSorted() {
        String[] inputArray = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] sortedArray = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        SortDepartments departments = new SortDepartments(inputArray);
        assertThat(departments.getSortedDepartments(), is(sortedArray));
    }

    @Test
    public void whenReverseSortThenGetThem() {
        String[] inputArray = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] sortedArray = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        SortDepartments departments = new SortDepartments(inputArray);
        assertThat(departments.getReverseSortedDepartments(), is(sortedArray));
    }

}