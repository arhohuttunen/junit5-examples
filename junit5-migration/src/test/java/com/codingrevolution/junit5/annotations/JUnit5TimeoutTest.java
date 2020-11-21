package com.codingrevolution.junit5.annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class JUnit5TimeoutTest {

    @Test
    @Disabled("This would fail the build, so the test is ignored")
    void shouldTimeout() {
        Assertions.assertTimeout(Duration.ofMillis(1), () -> Thread.sleep(5));
    }
}
