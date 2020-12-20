package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionAssertion {

    @Test
    void divideByZeroThrowsIllegalArgumentException() {
        Calculator calculator = new Calculator();
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
        assertEquals("Cannot divide by zero", thrown.getMessage());
    }
}
