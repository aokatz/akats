package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test Factorial
 * @author AKats
 */
public class FactorialTest {
    /**
     * Test факториала от нуля
     */
    @Test
    public void testZeroFuctorial() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(0), is(1));
    }
    /**
     * Test факториала от 5
     */
    @Test
    public void testFuctorial() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(5), is(120));
    }
}