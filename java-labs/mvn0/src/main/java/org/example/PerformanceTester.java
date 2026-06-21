package org.example;

public class PerformanceTester {
    public static void sleep() throws InterruptedException {
        Thread tread = Thread.currentThread();
        tread.sleep(1000);
        System.out.println("done");
    }
}
