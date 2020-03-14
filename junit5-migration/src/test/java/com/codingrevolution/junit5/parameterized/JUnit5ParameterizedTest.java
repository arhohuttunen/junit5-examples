package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnit5ParameterizedTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void fibonacciSequence(int input, int expected) {
        assertEquals(expected, Fibonacci.compute(input));
    }
}
