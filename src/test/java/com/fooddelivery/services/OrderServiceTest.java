import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.fooddelivery.models.Customer;
import com.fooddelivery.models.MenuItem;
import com.fooddelivery.models.Order;
import com.fooddelivery.services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest {
    private OrderService orderService;
    private Customer customer;
    private List<MenuItem> menuItems;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
        customer = new Customer("John Doe", "1234567890");
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Hamburger", 5.99));
        menuItems.add(new MenuItem("Fries", 2.99));
    }

    @Test
    public void testPlaceOrder() {
        Order order = orderService.placeOrder(customer, menuItems);
        assertNotNull(order);
        assertEquals(customer, order.getCustomer());
        assertEquals(2, order.getMenuItems().size());
        assertEquals("placed", order.getStatus());
    }

    @Test
    public void testCalculateOrderTotal() {
        Order order = orderService.placeOrder(customer, menuItems);
        double total = orderService.calculateOrderTotal(order);
        assertEquals(8.98, total);
    }

    @Test
    public void testOrderStatusManagement() {
        Order order = orderService.placeOrder(customer, menuItems);
        orderService.acceptOrder(order);
        assertEquals("accepted", order.getStatus());
        
        orderService.deliverOrder(order);
        assertEquals("delivered", order.getStatus());
    }
}