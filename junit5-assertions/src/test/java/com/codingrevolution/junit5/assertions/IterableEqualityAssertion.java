package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class IterableEqualityAssertion {

    @Test
    void iterablesEqual() {
        final List<String> list = Arrays.asList("orange", "mango", "banana");
        final List<String> expected = Arrays.asList("banana", "mango", "orange");

        Collections.sort(list);

        assertIterableEquals(expected, list);
    }
}
