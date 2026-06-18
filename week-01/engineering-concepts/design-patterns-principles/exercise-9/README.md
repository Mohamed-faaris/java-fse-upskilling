## Exercise 9: Implementing the Command Pattern
Scenario: You are developing a home automation system where commands can be issued to turn devices on or off. Use the Command Pattern to achieve this.
## Steps:
Create a New Java Project:
Create a new Java project named CommandPatternExample.
Define Command Interface:
Create an interface Command with a method execute().
Implement Concrete Commands:
Create classes LightOnCommand, LightOffCommand that implement Command.
Implement Invoker Class:
Create a class RemoteControl that holds a reference to a Command and a method to execute the command.
Implement Receiver Class:
Create a class Light with methods to turn on and off.
Test the Command Implementation:
Create a test class to demonstrate issuing commands using the RemoteControl.