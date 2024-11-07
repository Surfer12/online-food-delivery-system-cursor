package com.fooddelivery.services;

import com.fooddelivery.models.Order;
import com.fooddelivery.models.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Collections;

public class OrderService {
    // Use a thread-safe list
    private List<Order> orders;

    public OrderService() {
        this.orders = new CopyOnWriteArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public double calculateOrderTotal(Order order) {
        double total = 0.0;
        for (MenuItem item : order.getMenuItems()) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void updateOrderStatus(Order order, String status) {
        order.setStatus(status);
    }
}