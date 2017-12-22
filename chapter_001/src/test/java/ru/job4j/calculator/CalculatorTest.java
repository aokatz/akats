package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



/**
 * Test
 * @author Andrey Kats
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * Test of sum
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test of substruct
     */
    @Test
    public void whenSubstrustTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.substruct(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test of div
     */
    @Test
    public void whenDivTwoOverOneThenOne() {
        Calculator calc = new Calculator();
        calc.div(2D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test of multiple
     */
    @Test
    public void whenMultipleTwoOverOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
