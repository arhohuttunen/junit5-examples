package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomAssertionErrorMessage {

    @Test
    void addNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1, 2), "1 + 2 should equal 3");
    }

    @ParameterizedTest(name = "{0} + {1} should equal {2}")
    @CsvSource({
            "1, 2, 3",
            "2, 4, 6"
    })
    void addNumbers(int first, int second, int expected) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(first, second),
                () -> String.format("%d + %d should equal %d", first, second, expected));
    }
}
