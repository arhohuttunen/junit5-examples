package com.codingrevolution.categories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
class JUnit5TagTest {

    @Test
    void testMethod() {
        Assertions.assertEquals(3, 1 + 2);
    }
}
