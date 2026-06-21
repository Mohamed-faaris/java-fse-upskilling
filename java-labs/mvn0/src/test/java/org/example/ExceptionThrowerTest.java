package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionThrowerTest {

    @Test
    void testException() {

        ExceptionThrower obj = new ExceptionThrower();

        assertThrows(
                IllegalArgumentException.class,
                obj::throwException
        );
    }
}