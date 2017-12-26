package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
        int[] test = {2, 6, 1, 4};
        int[] result = {4, 1, 6, 2};
        assertThat(new Turn().back(test), is(result));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
        int[] test = {1, 2, 3, 4, 5};
        int[] result = {5, 4, 3, 2, 1};
        assertThat(new Turn().back(test), is(result));
    }
}