/*
 * ## Exercise 8: Implementing the Strategy Pattern
 * Scenario:
 * You are developing a payment system where different payment methods (e.g., Credit Card, PayPal) can
 * be selected at runtime. Use the Strategy Pattern to achieve this.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named StrategyPatternExample.
 * Define Strategy Interface:
 * Create an interface PaymentStrategy with a method pay().
 * Implement Concrete Strategies:
 * Create classes CreditCardPayment, PayPalPayment that implement PaymentStrategy.
 * Implement Context Class:
 * Create a class PaymentContext that holds a reference to PaymentStrategy and a method to execute the
 * strategy.
 * Test the Strategy Implementation:
 * Create a test class to demonstrate selecting and using different payment strategies.
 */
interface PaymentStrategy {
    void pay(double amount);
}   
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}
class PayPalPayment implements PaymentStrategy {
    private String email;
    public PayPalPayment(String email) {
        this.email = email;
    }
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        // TODO: Implement Implementing the Strategy Pattern
        PaymentContext creditCardPayment = new PaymentContext(new CreditCardPayment("1234-5678-9876-5432", "John Doe"));
        creditCardPayment.executePayment(100.0);

        PaymentContext payPalPayment = new PaymentContext(new PayPalPayment("john.doe@example.com"));
        payPalPayment.executePayment(100.0);
    }
}
