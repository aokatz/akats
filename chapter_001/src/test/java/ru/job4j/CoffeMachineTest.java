package ru.job4j;

import org.junit.Test;

import java.nio.channels.Channel;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CoffeMachineTest {

    @Test
    public void changes() {
        CoffeMachine coffeMachine = new CoffeMachine();
        assertThat(coffeMachine.changes(53, 35), is(new int[]{10, 5, 2, 1}));
    }
}