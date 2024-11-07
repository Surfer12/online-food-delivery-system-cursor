import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.fooddelivery.utils.DataStore;
import com.fooddelivery.models.Order;
import com.fooddelivery.models.Driver;
import com.fooddelivery.models.Customer;
import com.fooddelivery.models.MenuItem;

import java.util.List;

public class DataStoreTest {
    private DataStore dataStore;

    @BeforeEach
    public void setUp() {
        dataStore = new DataStore();
    }

    @Test
    public void testAddOrder() {
        Customer customer = new Customer("John Doe", "1234567890");
        MenuItem item = new MenuItem("Hamburger", 5.99);
        Order order = new Order(customer, List.of(item));
        
        dataStore.addOrder(order);
        
        assertEquals(1, dataStore.getOrders().size());
        assertEquals(order, dataStore.getOrders().get(0));
    }

    @Test
    public void testProcessOrdersFIFO() {
        Customer customer1 = new Customer("Alice", "0987654321");
        Customer customer2 = new Customer("Bob", "1231231234");
        MenuItem item = new MenuItem("Fries", 2.99);
        
        Order order1 = new Order(customer1, List.of(item));
        Order order2 = new Order(customer2, List.of(item));
        
        dataStore.addOrder(order1);
        dataStore.addOrder(order2);
        
        Order processedOrder = dataStore.processNextOrder();
        
        assertEquals(order1, processedOrder);
        assertEquals(1, dataStore.getOrders().size());
    }

    @Test
    public void testAddDriver() {
        Driver driver = new Driver("Driver One", "Location A");
        
        dataStore.addDriver(driver);
        
        assertEquals(1, dataStore.getDrivers().size());
        assertEquals(driver, dataStore.getDrivers().get(0));
    }

    @Test
    public void testGetDrivers() {
        Driver driver1 = new Driver("Driver One", "Location A");
        Driver driver2 = new Driver("Driver Two", "Location B");
        
        dataStore.addDriver(driver1);
        dataStore.addDriver(driver2);
        
        List<Driver> drivers = dataStore.getDrivers();
        
        assertEquals(2, drivers.size());
        assertTrue(drivers.contains(driver1));
        assertTrue(drivers.contains(driver2));
    }
}