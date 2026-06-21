import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class OrderedTests {

    @Test
    @Order(1)
    void login() {
        System.out.println("Login");
    }

    @Test
    @Order(2)
    void search() {
        System.out.println("Search");
    }

    @Test
    @Order(3)
    void checkout() {
        System.out.println("Checkout");
    }
}