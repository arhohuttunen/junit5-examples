package com.codingrevolution.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;

class TimeoutTest {

    @Test
    void shouldTimeout() {
        Assertions.assertTimeout(ofMillis(1), () -> Thread.sleep(5));
    }
}
