package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Test Создание массива квадратов
 * @author AKats
 */
public class SquareTest {

    @Test
    public void wenBoundIsFiveThenResult() {
        Square square = new Square();
        int[] result = {1, 4, 9, 16, 25};
        assertThat(square.calculate(5), is(result));
    }
}