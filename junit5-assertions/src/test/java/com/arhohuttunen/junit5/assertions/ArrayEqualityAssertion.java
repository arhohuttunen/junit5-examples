package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayEqualityAssertion {

    @Test
    void arraysEqual() {
        final int[] array = { 3, 2, 1 };
        final int[] expected = { 1, 2, 3 };

        Arrays.sort(array);

        assertArrayEquals(expected, array);
    }
}
