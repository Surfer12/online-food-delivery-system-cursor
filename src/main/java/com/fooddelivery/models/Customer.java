package com.fooddelivery.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String contactInfo;
    private List<Order> orders;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}