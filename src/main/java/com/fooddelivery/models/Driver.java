package com.fooddelivery.models;
public class Driver {
    private String name;
    private String location;
    private int[] ratings;
    private int ratingCount;

    public Driver(String name, String location) {
        this.name = name;
        this.location = location;
        this.ratings = new int[10]; // Maximum of 10 ratings
        this.ratingCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void acceptOrder() {
        // Logic for accepting an order
    }

    public void deliverOrder() {
        // Logic for delivering an order
    }

    public void addRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }

        if (ratingCount < 10) {
            ratings[ratingCount] = rating;
            ratingCount++;
        } else {
            // Shift ratings to the left to make space for the new rating
            System.arraycopy(ratings, 1, ratings, 0, 9);
            ratings[9] = rating;
        }
    }

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < ratingCount; i++) {
            total += ratings[i];
        }
        return (double) total / ratingCount;
    }
}