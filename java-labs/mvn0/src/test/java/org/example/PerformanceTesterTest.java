package org.example;

import org.junit.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {
    @Test
    public void test(){
        assertTimeout(Duration.ofMillis(200), PerformanceTester::sleep);
        assertTimeout(Duration.ofMillis(1200), PerformanceTester::sleep);
    }
}
