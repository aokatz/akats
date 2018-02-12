package ru.job4j.orderbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;


import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class OrderBookTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOuput() {
        System.setOut(stdout);
    }


    @Test
    public void whenAddOrderShouldAddIt() {
        OrderBook orderBook = new OrderBook();
        Order order1 = new Order(1, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 150);
        Order order2 = new Order(2, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(115), 70);
        Order order3 = new Order(3, "SBER", Order.Type.ADD, Order.Action.BID, new BigDecimal(30), 80);
        Order order4 = new Order(4, "GAZP", Order.Type.ADD, Order.Action.BID, new BigDecimal(10), 50);
        Order order5 = new Order(5, "GAZP", Order.Type.ADD, Order.Action.ASK, new BigDecimal(111), 50);
        orderBook.processOrder(order1);
        orderBook.processOrder(order2);
        orderBook.processOrder(order3);
        orderBook.processOrder(order4);
        orderBook.processOrder(order5);
        System.out.println(orderBook);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuffer()
                                .append("GAZP\n")
                                .append("|        |  111|      50|\n")
                                .append("|      50|   10|        |\n")
                                .append("SBER\n")
                                .append("|        |  130|     150|\n")
                                .append("|        |  115|      70|\n")
                                .append("|      80|   30|        |\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }


    @Test
    public void whenAddSamePriceShouldMerge() {
        OrderBook orderBook = new OrderBook();
        Order order1 = new Order(1, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 150);
        Order order2 = new Order(2, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 50);
        orderBook.processOrder(order1);
        orderBook.processOrder(order2);
        System.out.println(orderBook);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuffer()
                                .append("SBER\n")
                                .append("|        |  130|     200|\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenCanTradeShouldTrade() {
        OrderBook orderBook = new OrderBook();
        Order order1 = new Order(1, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 150);
        Order order2 = new Order(2, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 50);
        Order order3 = new Order(3, "SBER", Order.Type.ADD, Order.Action.BID, new BigDecimal(133), 210);
        orderBook.processOrder(order1);
        orderBook.processOrder(order2);
        orderBook.processOrder(order3);
        System.out.println(orderBook);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuffer()
                                .append("SBER\n")
                                .append("|      10|  133|        |\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDeleteShouldRemoveOrder() {
        OrderBook orderBook = new OrderBook();
        Order order1 = new Order(1, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 150);
        Order order2 = new Order(2, "SBER", Order.Type.ADD, Order.Action.ASK, new BigDecimal(130), 50);
        Order order3 = new Order(2, "SBER", Order.Type.DELETE, Order.Action.ASK, new BigDecimal(130), 100);
        orderBook.processOrder(order1);
        orderBook.processOrder(order2);
        orderBook.processOrder(order3);
        System.out.println(orderBook);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuffer()
                                .append("SBER\n")
                                .append("|        |  130|     100|\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}