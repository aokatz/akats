package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    /**
     * Тестирование заполнения матрицы размером 3х3
     */
    @Test
    public void whenSizeThreeThenMultiple() {
        int[][] result = {
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}
        };
        assertThat(new Matrix().multiple(3), is(result));
    }
}