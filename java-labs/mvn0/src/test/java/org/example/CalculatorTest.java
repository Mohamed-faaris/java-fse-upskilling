package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 2;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 2;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(10, result);
    }

    @Test
    public void testMultiply0() {
        assertEquals(0, calculator.multiply(0, 2));
        assertEquals(0, calculator.multiply(0, 0));
        assertEquals(10, calculator.multiply(2, 5));
    }


    @After
    public void tearDownCalculator() {
        calculator = null;
    }


}
