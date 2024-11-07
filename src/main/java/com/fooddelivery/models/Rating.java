package com.fooddelivery.models;
import java.util.ArrayList;
import java.util.List;

public class Rating {
    private int ratingValue;

    public Rating(int ratingValue) {
        if (ratingValue < 1 || ratingValue > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        this.ratingValue = ratingValue;
    }

    public int getRatingValue() {
        return ratingValue;
    }
}