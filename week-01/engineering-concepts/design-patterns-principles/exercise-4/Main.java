/*
 * ## Exercise 4: Implementing the Adapter Pattern
 * Scenario:
 * You are developing a payment processing system that needs to integrate with multiple third-party
 * payment gateways with different interfaces. Use the Adapter Pattern to achieve this.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named AdapterPatternExample.
 * Define Target Interface:
 * Create an interface PaymentProcessor with methods like processPayment().
 * Implement Adaptee Classes:
 * Create classes for different payment gateways with their own methods.
 * Implement the Adapter Class:
 * Create an adapter class for each payment gateway that implements PaymentProcessor and translates the
 * calls to the gateway-specific methods.
 * Test the Adapter Implementation:
 * Create a test class to demonstrate the use of different payment gateways through the adapter.
 */
interface PaymentProcessor {
    void processPayment(double amount);
}
class PayPal {
    public void payWithPayPal(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
class Stripe {
    public void payWithStripe(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;  
    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }
    public void processPayment(double amount) {
        payPal.payWithPayPal(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;
    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }
    public void processPayment(double amount) {
        stripe.payWithStripe(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);


    }
}

