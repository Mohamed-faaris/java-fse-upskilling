package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {

    private EvenChecker evenChecker;

    @BeforeEach
    void setup() {
        evenChecker = new EvenChecker();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    void testOdd(int number) {
        assertFalse(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number));
    }

    @AfterEach
    void tearDown() {
        evenChecker = null;
    }
}