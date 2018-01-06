package ru.job4j.shapes;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                .append("++++")
                .append(System.lineSeparator())
                .append("+  +")
                .append(System.lineSeparator())
                .append("+  +")
                .append(System.lineSeparator())
                .append("++++").toString()));
    }
}