package com.arhohuttunen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void addNumbers() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 2);
        Assertions.assertEquals(3, sum);
    }
}
