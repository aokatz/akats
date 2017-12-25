package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Тестирование удаления дублей из массива
 * @author AKats
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] testArray = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expectArray =  {"Привет", "Мир", "Супер"};
        String[] resultArray = (new ArrayDuplicate()).remove(testArray);
        assertThat(resultArray, is(expectArray));
    }
}