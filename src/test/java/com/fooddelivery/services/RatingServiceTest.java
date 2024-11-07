import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.fooddelivery.models.Driver;
import com.fooddelivery.services.RatingService;

public class RatingServiceTest {
    private RatingService ratingService;
    private Driver driver;

    @BeforeEach
    public void setUp() {
        ratingService = new RatingService();
        driver = new Driver("John Doe", "Location A");
    }

    @Test
    public void testAddRating() {
        ratingService.addRating(driver, 5);
        assertEquals(5, ratingService.getAverageRating(driver));
        
        ratingService.addRating(driver, 3);
        assertEquals(4, ratingService.getAverageRating(driver));
    }

    @Test
    public void testMaxRatingsLimit() {
        for (int i = 1; i <= 12; i++) {
            ratingService.addRating(driver, i % 5 + 1); // Ratings from 1 to 5
        }
        assertEquals(5, ratingService.getAverageRating(driver)); // Should only keep the last 10 ratings
    }

    @Test
    public void testInvalidRating() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ratingService.addRating(driver, 6); // Invalid rating
        });
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
    }
}