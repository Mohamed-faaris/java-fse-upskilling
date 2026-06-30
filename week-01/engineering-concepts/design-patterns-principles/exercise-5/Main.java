/*
 * ## Exercise 5: Implementing the Decorator Pattern
 * Scenario:
 * You are developing a notification system where notifications can be sent via multiple channels
 * (e.g., Email, SMS). Use the Decorator Pattern to add functionalities dynamically.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named DecoratorPatternExample.
 * Define Component Interface:
 * Create an interface Notifier with a method send().
 * Implement Concrete Component:
 * Create a class EmailNotifier that implements Notifier.
 * Implement Decorator Classes:
 * Create abstract decorator class NotifierDecorator that implements Notifier and holds a reference to
 * a Notifier object.
 * Create concrete decorator classes like SMSNotifierDecorator, SlackNotifierDecorator that extend
 * NotifierDecorator.
 * Test the Decorator Implementation:
 * Create a test class to demonstrate sending notifications via multiple channels using decorators.
 */

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}


public class Main {
    public static void main(String[] args) {
        // TODO: Implement Implementing the Decorator Pattern
        Notifier notifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        notifier.send("Hello, this is a test notification!");
    }
}
