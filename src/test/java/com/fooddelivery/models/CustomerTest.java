import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fooddelivery.models.Customer;
import com.fooddelivery.models.MenuItem;
import com.fooddelivery.models.Order;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    private Customer customer;
    private List<MenuItem> menuItems;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", "john@example.com", "1234567890");
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Hamburger", 5.99));
        menuItems.add(new MenuItem("Fries", 2.99));
    }

    @Test
    public void testPlaceOrder() {
        Order order = customer.placeOrder(menuItems);
        assertNotNull(order);
        assertEquals(customer, order.getCustomer());
        assertEquals(menuItems, order.getMenuItems());
        assertEquals("placed", order.getStatus());
    }

    @Test
    public void testCustomerDetails() {
        assertEquals("John Doe", customer.getName());
        assertEquals("john@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getContactNumber());
    }
}