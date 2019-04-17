package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class IterableEqualityAssertion {

    @Test
    void iterablesEqual() {
        final List<String> array = Arrays.asList("banana", "orange", "mango");
        final List<String> expected = Arrays.asList("banana", "orange");
        assertIterableEquals(expected, array.subList(0, 2));
    }
}
