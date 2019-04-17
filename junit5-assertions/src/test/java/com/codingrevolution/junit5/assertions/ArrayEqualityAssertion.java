package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayEqualityAssertion {

    @Test
    void arraysEqual() {
        final int[] expected = { 1, 2, 3 };
        final int[] array = { 3, 2, 1 };

        Arrays.sort(array);

        assertArrayEquals(expected, array);
    }
}
