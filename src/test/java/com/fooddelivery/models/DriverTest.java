import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fooddelivery.models.Driver;
import com.fooddelivery.models.Order;

public class DriverTest {
    private Driver driver;
    private Order order;

    @BeforeEach
    public void setUp() {
        driver = new Driver("John Doe", "123 Main St");
        order = new Order(/* parameters for order initialization */);
    }

    @Test
    public void testAcceptOrder() {
        driver.acceptOrder(order);
        assertTrue(driver.getCurrentOrders().contains(order));
    }

    @Test
    public void testDeliverOrder() {
        driver.acceptOrder(order);
        driver.deliverOrder(order);
        assertFalse(driver.getCurrentOrders().contains(order));
    }

    @Test
    public void testDriverLocation() {
        assertEquals("123 Main St", driver.getLocation());
        driver.setLocation("456 Elm St");
        assertEquals("456 Elm St", driver.getLocation());
    }

    @Test
    public void testDriverName() {
        assertEquals("John Doe", driver.getName());
        driver.setName("Jane Smith");
        assertEquals("Jane Smith", driver.getName());
    }
}