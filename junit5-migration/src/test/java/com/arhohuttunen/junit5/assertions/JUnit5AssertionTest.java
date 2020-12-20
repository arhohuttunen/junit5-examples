package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class JUnit5AssertionTest {

    @Test
    @Disabled("This would fail the build, so the test is ignored")
    void shouldFailWithMessage() {
        Assertions.assertEquals(1, 2, () -> "numbers " + 1 + " and " + 2 + " are not equal");
    }
}
