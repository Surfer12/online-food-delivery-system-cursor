import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fooddelivery.models.MenuItem;

public class MenuItemTest {
    private MenuItem menuItem;

    @BeforeEach
    public void setUp() {
        menuItem = new MenuItem("Hamburger", 5.99);
    }

    @Test
    public void testGetName() {
        assertEquals("Hamburger", menuItem.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(5.99, menuItem.getPrice());
    }

    @Test
    public void testSetName() {
        menuItem.setName("Fries");
        assertEquals("Fries", menuItem.getName());
    }

    @Test
    public void testSetPrice() {
        menuItem.setPrice(2.99);
        assertEquals(2.99, menuItem.getPrice());
    }
}