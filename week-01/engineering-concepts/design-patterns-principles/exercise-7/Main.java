/*
 * ## Exercise 7: Implementing the Observer Pattern
 * Scenario:
 * You are developing a stock market monitoring application where multiple clients need to be notified
 * whenever stock prices change. Use the Observer Pattern to achieve this.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named ObserverPatternExample.
 * Define Subject Interface:
 * Create an interface Stock with methods to register, deregister, and notify observers.
 * Implement Concrete Subject:
 * Create a class StockMarket that implements Stock and maintains a list of observers.
 * Define Observer Interface:
 * Create an interface Observer with a method update().
 * Implement Concrete Observers:
 * Create classes MobileApp, WebApp that implement Observer.
 * Test the Observer Implementation:
 * Create a test class to demonstrate the registration and notification of observers.
 */
class StockMarket {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println(appName + " - Stock: " + stockName + ", Price: $" + stockPrice);
    }
}

class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println(appName + " - Stock: " + stockName + ", Price: $" + stockPrice);
    }
}

public class Main {
    public static void main(String[] args) {
        // TODO: Implement Implementing the Observer Pattern
        StockMarket stockMarket = new StockMarket("AAPL");
        MobileApp mobileApp = new MobileApp("Mobile App");
        WebApp webApp = new WebApp("Web App");
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        stockMarket.setStockPrice(150.0);
        stockMarket.setStockPrice(155.0);
    }
}
