package com.codingrevolution.annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JUnit5ExceptionTest {

    @Test
    void shouldThrowAnException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });
    }
}
