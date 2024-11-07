package com.fooddelivery.services;

import com.fooddelivery.models.Driver;
import com.fooddelivery.models.Rating;

import java.util.ArrayList;
import java.util.List;

public class RatingService {
    private static final int MAX_RATINGS = 10;

    public void addRating(Driver driver, int ratingValue) {
        if (driver != null) {
            List<Rating> ratings = driver.getRatings();
            if (ratings.size() >= MAX_RATINGS) {
                ratings.remove(0); // Remove the oldest rating
            }
            ratings.add(new Rating(ratingValue));
            driver.setRatings(ratings);
        }
    }

    public double calculateAverageRating(Driver driver) {
        if (driver == null || driver.getRatings().isEmpty()) {
            return 0;
        }
        List<Rating> ratings = driver.getRatings();
        int total = 0;
        for (Rating rating : ratings) {
            total += rating.getRatingValue();
        }
        return (double) total / ratings.size();
    }
}