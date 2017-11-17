package com.codingrevolution.rules;

import com.codingrevolution.rules.PerformanceLoggerExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PerformanceLoggerExtension.class)
class JUnit5PerformanceLoggerTest {

    @Test
    void shouldLogPerformance() throws InterruptedException {
        Thread.sleep(10);
    }
}
