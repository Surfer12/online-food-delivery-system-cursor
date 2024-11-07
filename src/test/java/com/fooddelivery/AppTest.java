import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAppInitialization() {
        // Assuming App has a method to initialize services
        App app = new App();
        app.initializeServices();
        
        // Check if services are initialized correctly
        assertNotNull(app.getOrderService());
        assertNotNull(app.getDeliveryService());
        assertNotNull(app.getRatingService());
    }
}