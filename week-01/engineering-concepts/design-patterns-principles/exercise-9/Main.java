/*
 * ## Exercise 9: Implementing the Command Pattern
 * Scenario: You are developing a home automation system where commands can be issued to turn devices
 * on or off. Use the Command Pattern to achieve this.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named CommandPatternExample.
 * Define Command Interface:
 * Create an interface Command with a method execute().
 * Implement Concrete Commands:
 * Create classes LightOnCommand, LightOffCommand that implement Command.
 * Implement Invoker Class:
 * Create a class RemoteControl that holds a reference to a Command and a method to execute the
 * command.
 * Implement Receiver Class:
 * Create a class Light with methods to turn on and off.
 * Test the Command Implementation:
 * Create a test class to demonstrate issuing commands using the RemoteControl.
 */
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

interface Command {
    void execute();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        // TODO: Implement Implementing the Command Pattern
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.pressButton();
        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.pressButton();
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.pressButton();
    }
}
