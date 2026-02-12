package com.arhohuttunen.junit5.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JUnit4ParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    private final int input;
    private final int expected;

    public JUnit4ParameterizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void fibonacciSequence() {
        assertEquals(expected, Fibonacci.compute(input));
    }
}
