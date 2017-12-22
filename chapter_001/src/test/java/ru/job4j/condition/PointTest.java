package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceTo() {
        Point point = new Point(0, 0);
        double result = point.distanceTo(new Point(1, 0));
        double expected = 1;
        assertThat(result, is(expected));
    }
}