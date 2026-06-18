## Exercise 7: Implementing the Observer Pattern
Scenario:
You are developing a stock market monitoring application where multiple clients need to be notified whenever stock prices change. Use the Observer Pattern to achieve this.
## Steps:
Create a New Java Project:
Create a new Java project named ObserverPatternExample.
Define Subject Interface:
Create an interface Stock with methods to register, deregister, and notify observers.
Implement Concrete Subject:
Create a class StockMarket that implements Stock and maintains a list of observers.
Define Observer Interface:
Create an interface Observer with a method update().
Implement Concrete Observers:
Create classes MobileApp, WebApp that implement Observer.
Test the Observer Implementation:
Create a test class to demonstrate the registration and notification of observers.