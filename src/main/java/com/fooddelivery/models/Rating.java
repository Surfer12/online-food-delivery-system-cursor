package com.fooddelivery.models;
import java.util.ArrayList;
import java.util.List;

public class Rating {
    private int ratingValue;
    private static final int MAX_RATINGS = 10;
    private List<Integer> ratings;

    public Rating() {
        ratings = new ArrayList<>();
    }

    public void addRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        if (ratings.size() >= MAX_RATINGS) {
            ratings.remove(0); // Remove the oldest rating
        }
        ratings.add(rating);
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (int r : ratings) {
            total += r;
        }
        return (double) total / ratings.size();
    }

    public List<Integer> getRatings() {
        return new ArrayList<>(ratings);
    }
}