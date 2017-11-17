package com.codingrevolution.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PerformanceLoggerExtension.class)
public class PerformanceLoggerTest {

    @Test
    public void shouldLogPerformance() throws InterruptedException {
        Thread.sleep(10);
    }
}
