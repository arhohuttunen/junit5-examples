package com.codingrevolution.junit4;

import org.junit.Rule;
import org.junit.Test;

public class PerformanceLoggerTest {

    @Rule
    public PerformanceLoggerRule logger = new PerformanceLoggerRule();

    @Test
    public void shouldLogPerformance() throws InterruptedException {
        Thread.sleep(10);
    }
}
