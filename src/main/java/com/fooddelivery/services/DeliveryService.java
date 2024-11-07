package com.fooddelivery.services;

import com.fooddelivery.models.Order;
import com.fooddelivery.models.Driver;

import java.util.Queue;
import java.util.LinkedList;

public class DeliveryService {
    private Queue<Order> orderQueue;

    public DeliveryService() {
        this.orderQueue = new LinkedList<>();
    }

    public void acceptOrder(Order order) {
        orderQueue.offer(order);
        order.setStatus("Accepted");
    }

    public Order deliverOrder(Driver driver) {
        if (orderQueue.isEmpty()) {
            return null; // No orders to deliver
        }
        Order order = orderQueue.poll();
        if (order != null) {
            order.setStatus("Delivered");
            // Additional logic for delivery can be added here
        }
        return order;
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }
}