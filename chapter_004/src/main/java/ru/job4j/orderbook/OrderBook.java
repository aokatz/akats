package ru.job4j.orderbook;

import java.math.BigDecimal;
import java.util.*;

/**
 * Order book class
 *
 * @author AKats
 */
public class OrderBook {
    private Map<String, List<Order>> books = new HashMap<>();


    private Order trade(List<Order> orders, Order order) {
        switch (order.getAction()) {
            case BID:
                Order minAskOrder = orders.stream().filter(a -> a.getAction().equals(Order.Action.ASK)).min(Comparator.comparing(Order::getPrice)).orElse(null);
                while (orders.size() > 0 && minAskOrder != null && order.getPrice().compareTo(minAskOrder.getPrice()) >= 0 && order.getVolume() > 0) {
                    int minAskOrderVolume = minAskOrder.getVolume();
                    minAskOrder.setVolume(minAskOrderVolume - order.getVolume());
                    order.setVolume(order.getVolume() - minAskOrderVolume);
                    if (minAskOrder.getVolume() <= 0) {
                        orders.remove(minAskOrder);
                    }
                    minAskOrder = orders.stream().filter(a -> a.getAction().equals(Order.Action.ASK)).min(Comparator.comparing(Order::getPrice)).orElse(order);
                }
                break;
            case ASK:
                Order maxBidOrder = orders.stream().filter(a -> a.getAction().equals(Order.Action.BID)).max(Comparator.comparing(Order::getPrice)).orElse(null);
                while (orders.size() > 0 && maxBidOrder != null && order.getPrice().compareTo(maxBidOrder.getPrice()) <= 0 && order.getVolume() > 0) {
                    int maxBidOrderVolume = maxBidOrder.getVolume();
                    maxBidOrder.setVolume(maxBidOrderVolume - order.getVolume());
                    order.setVolume(order.getVolume() - maxBidOrderVolume);
                    if (maxBidOrder.getVolume() <= 0) {
                        orders.remove(maxBidOrder);
                    }
                    maxBidOrder = orders.stream().filter(a -> a.getAction().equals(Order.Action.BID)).max(Comparator.comparing(Order::getPrice)).orElse(order);
                }
                break;
            default:
                break;
        }
        return (order.getVolume() >= 0) ? order : null;
    }

    private void remove(Order order) {
        List<Order> orders = books.get(order.getBook());
        if (orders.contains(order)) {
            Order removeOrder = orders.get(orders.indexOf(order));
            if (removeOrder.getVolume() <= order.getVolume()) {
                orders.remove(order);
                this.books.put(order.getBook(), orders);
            } else {
                removeOrder.setVolume(removeOrder.getVolume() - order.getVolume());
            }
        }
    }

    private void add(Order order) {
        List<Order> orders = books.get(order.getBook());
        if (orders == null) {
            orders = new LinkedList<>();
        }
        order = trade(orders, order);
        if (order != null) {
            if (orders.contains(order)) {
                orders.get(orders.indexOf(order)).addVolume(order.getVolume());
            } else {
                orders.add(order);
            }
            Collections.sort(orders);
            books.put(order.getBook(), orders);
        }
    }

    public void processOrder(Order order) {
        switch (order.getType()) {
            case ADD:
                add(order);
                break;
            case DELETE:
                remove(order);
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (String book : books.keySet()) {
            res += book + "\n";
            for (Order order : books.get(book)) {
                res += order + "\n";
            }
        }
        return res;
    }
}
