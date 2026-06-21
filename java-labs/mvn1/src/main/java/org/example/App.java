package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.trace("test {}", System.nanoTime());
        logger.trace("now {}", LocalDate.now());

        logger.trace("Trace message");
        logger.debug("Debug message");
        logger.info("Application started");
        logger.warn("Low memory warning");
        logger.error("Database connection failed");
    }
}
