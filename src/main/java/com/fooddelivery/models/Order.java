package com.fooddelivery.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<MenuItem> items;
    private String status; // e.g., "placed", "accepted", "delivered"

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.status = "placed";
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MenuItem[] getMenuItems() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getMenuItems'");
    }
}