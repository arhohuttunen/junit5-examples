package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TimeoutAssertion {

    @Test
    void returnValueBeforeTimeoutExceeded() {
        final String message = assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
            return "a message";
        });
        assertEquals("a message", message);
    }

    @Test
    void abortWhenTimeoutExceeded() {
        final String message = assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
            Thread.sleep(100);
            return "another message";
        });
        assertEquals("another message", message);
    }
}
