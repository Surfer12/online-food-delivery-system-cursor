package com.fooddelivery;

import com.fooddelivery.services.DeliveryService;
import com.fooddelivery.services.OrderService;
import com.fooddelivery.services.RatingService;

public class App {
    public static void main(String[] args) {
        // Initialize services
        OrderService orderService = new OrderService();
        DeliveryService deliveryService = new DeliveryService();
        RatingService ratingService = new RatingService();

        // Application logic can be added here
        System.out.println("Online Food Delivery System is running...");
    }
}