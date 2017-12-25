package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FindLoopTest {
    /**
     * Поиск элемента в массиве и возвращение его индекса
     */
    @Test
    public void whenFoundElementThenReturnIndex() {
        FindLoop findLoop = new FindLoop();
        int[] data = {1, 2, 3};
        assertThat(findLoop.indexOf(data, 2), is(1));
    }

    /**
     * Если элемент не найден, возвращаем -1
     */
    @Test
    public void whenNotFoundElementThenReturnDefault() {
        FindLoop findLoop = new FindLoop();
        int[] data = {1, 2, 3};
        assertThat(findLoop.indexOf(data, 5), is(-1));
    }
}