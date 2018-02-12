package ru.job4j.orderbook;


import java.math.BigDecimal;
import java.util.Objects;

/**
 * Order class
 *
 * @author AKats
 */
public class Order implements Comparable<Order> {

    enum Type {
        ADD, DELETE
    }

    enum Action {
        BID, ASK
    }

    private final long id;
    private final String book;
    private final Type type;
    private final Action action;
    private BigDecimal price;
    private int volume;

    public Type getType() {
        return type;
    }

    public Action getAction() {
        return action;
    }

    public String getBook() {
        return book;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void addVolume(int volume) {
        this.volume += volume;
    }

    public Order(long id, String book, Type type, Action action, BigDecimal price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return price.equals(order.price)
                && Objects.equals(book, order.book)
                && action == order.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, action, price);
    }

    @Override
    public String toString() {
        String res = "";

        switch (this.action) {
            case ASK:
                res += "|        |" + String.format("%5s", this.price) + String.format("|%8d|", this.volume);
                break;
            case BID:
                res += String.format("|%8d|", this.volume) + String.format("%5s", this.price) + "|        |";
                break;
            default:
                break;
        }
        return res;
    }

    @Override
    public int compareTo(Order o) {
        if (this.book.equals(o.getBook())) {
            return o.getPrice().compareTo(this.getPrice());
        }
        return this.book.compareTo(o.getBook());
    }
}
