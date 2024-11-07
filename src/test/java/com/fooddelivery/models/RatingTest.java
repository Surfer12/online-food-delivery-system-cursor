import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = new Rating();
    }

    @Test
    void testSetAndGetRatingValue() {
        rating.setRatingValue(5);
        assertEquals(5, rating.getRatingValue());
    }

    @Test
    void testSetInvalidRatingValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rating.setRatingValue(6);
        });
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
    }

    @Test
    void testAddRating() {
        rating.addRating(4);
        assertEquals(4, rating.getAverageRating());
    }

    @Test
    void testAddMultipleRatings() {
        rating.addRating(3);
        rating.addRating(5);
        assertEquals(4, rating.getAverageRating());
    }

    @Test
    void testMaxRatingsLimit() {
        for (int i = 0; i < 12; i++) {
            rating.addRating(5);
        }
        assertEquals(10, rating.getRatingsCount());
    }
}