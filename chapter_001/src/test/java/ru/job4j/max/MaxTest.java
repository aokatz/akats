package ru.job4j.max;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author AKats
 */
public class MaxTest {
    /**
     * Test max
     */
    @Test
    public void max() {
        Max maxumum = new Max();
        assertThat(maxumum.max(1, 2), is(2));
    }

    /**
     * Test max of three numbers
     */
    @Test
    public void maxOfThree() {
        Max maxumum = new Max();
        assertThat(maxumum.max(1, 2, 3), is(3));
    }
}