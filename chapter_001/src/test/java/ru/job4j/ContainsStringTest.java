package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author AKats
 */
public class ContainsStringTest {
    /**
     * Test поиск подстроки
     */
    @Test
    public void wenContainsThenTrue() {
        assertThat(ContainsString.contains("Привет", "иве"), is(true));
    }
}