import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.fooddelivery.models.Driver;
import com.fooddelivery.models.Order;
import com.fooddelivery.services.DeliveryService;

public class DeliveryServiceTest {
    private DeliveryService deliveryService;
    private Driver driver;
    private Order order;

    @BeforeEach
    public void setUp() {
        deliveryService = new DeliveryService();
        driver = new Driver("John Doe", "123 Main St");
        order = new Order(/* parameters for order initialization */);
    }

    @Test
    public void testAcceptOrder() {
        deliveryService.acceptOrder(driver, order);
        assertEquals(order.getStatus(), "accepted");
        assertEquals(order.getDriver(), driver);
    }

    @Test
    public void testDeliverOrder() {
        deliveryService.acceptOrder(driver, order);
        deliveryService.deliverOrder(order);
        assertEquals(order.getStatus(), "delivered");
    }

    @Test
    public void testDriverLocationUpdate() {
        deliveryService.updateDriverLocation(driver, "456 Elm St");
        assertEquals(driver.getLocation(), "456 Elm St");
    }
}