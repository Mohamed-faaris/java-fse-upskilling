/*
 * ## Exercise 1: Implementing the Singleton Pattern
 * Scenario:
 * You need to ensure that a logging utility class in your application has only one instance throughout
 * the application lifecycle to ensure consistent logging.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named SingletonPatternExample.
 * Define a Singleton Class:
 * Create a class named Logger that has a private static instance of itself.
 * Ensure the constructor of Logger is private.
 * Provide a public static method to get the instance of the Logger class.
 * Implement the Singleton Pattern:
 * Write code to ensure that the Logger class follows the Singleton design pattern.
 * Test the Singleton Implementation:
 * Create a test class to verify that only one instance of Logger is created and used across the
 * application.
 */
class Logger {
    enum LogLevel {
        INFO,
        DEBUG,
        ERROR;
    }

    private static Logger instance;
    private LogLevel logLevel = LogLevel.INFO;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void log(String message, LogLevel level) {
        if (level.ordinal() >= logLevel.ordinal()) {
            System.out.println("[" + level + "] " + message);
        }
    }
}

public class Main {
    
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1 == logger2);
    }
}

// ❯ javac Main.java && java Main
// true