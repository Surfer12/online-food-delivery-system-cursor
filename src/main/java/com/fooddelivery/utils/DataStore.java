package com.fooddelivery.utils;

import com.fooddelivery.models.Order;
import com.fooddelivery.models.Driver;
import com.fooddelivery.models.Rating;

import java.util.LinkedList;
import java.util.Queue;

public class DataStore {
    private Queue<Order> orderQueue;
    private Driver[] drivers;
    private Rating[] driverRatings;

    public DataStore() {
        this.orderQueue = new LinkedList<>();
        this.drivers = new Driver[10]; // Assuming a maximum of 10 drivers
        this.driverRatings = new Rating[10]; // Assuming a maximum of 10 ratings per driver
    }

    public void addOrder(Order order) {
        orderQueue.offer(order);
    }

    public Order processNextOrder() {
        return orderQueue.poll();
    }

    public void addDriver(Driver driver, int index) {
        if (index >= 0 && index < drivers.length) {
            drivers[index] = driver;
        }
    }

    public Driver getDriver(int index) {
        if (index >= 0 && index < drivers.length) {
            return drivers[index];
        }
        return null;
    }

    public void addRating(int driverIndex, Rating rating) {
        if (driverIndex >= 0 && driverIndex < driverRatings.length) {
            // Shift ratings to maintain only the latest 10
            for (int i = 1; i < driverRatings.length; i++) {
                driverRatings[i - 1] = driverRatings[i];
            }
            driverRatings[driverRatings.length - 1] = rating;
        }
    }

    public Rating[] getRatings(int driverIndex) {
        if (driverIndex >= 0 && driverIndex < driverRatings.length) {
            return driverRatings;
        }
        return null;
    }
}