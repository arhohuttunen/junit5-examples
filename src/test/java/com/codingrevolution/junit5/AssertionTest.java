package com.codingrevolution.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssertionTest {

    @Test
    void shouldFailWithMessage() {
        Assertions.assertTrue(1 == 2,
                () -> "numbers " + 1 + " and " + 2 + " are not equal");
    }
}
