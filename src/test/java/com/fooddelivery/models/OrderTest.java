import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fooddelivery.models.Customer;
import com.fooddelivery.models.MenuItem;
import com.fooddelivery.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    private Order order;
    private Customer customer;
    private MenuItem burger;
    private MenuItem fries;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", "1234567890");
        burger = new MenuItem("Hamburger", 5.99);
        fries = new MenuItem("Fries", 2.99);
        List<MenuItem> items = new ArrayList<>();
        items.add(burger);
        items.add(fries);
        order = new Order(customer, items);
    }

    @Test
    public void testOrderStatusInitiallyPlaced() {
        assertEquals("placed", order.getStatus());
    }

    @Test
    public void testCalculateTotal() {
        double expectedTotal = burger.getPrice() + fries.getPrice();
        assertEquals(expectedTotal, order.calculateTotal());
    }

    @Test
    public void testUpdateOrderStatus() {
        order.setStatus("accepted");
        assertEquals("accepted", order.getStatus());
    }

    @Test
    public void testAddMenuItem() {
        MenuItem drink = new MenuItem("Drink", 1.99);
        order.addMenuItem(drink);
        assertTrue(order.getMenuItems().contains(drink));
    }

    @Test
    public void testRemoveMenuItem() {
        order.removeMenuItem(fries);
        assertFalse(order.getMenuItems().contains(fries));
    }
}