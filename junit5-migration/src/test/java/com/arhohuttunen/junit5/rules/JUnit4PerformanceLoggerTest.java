package com.arhohuttunen.junit5.rules;

import org.junit.Rule;
import org.junit.Test;

public class JUnit4PerformanceLoggerTest {

    @Rule
    public PerformanceLoggerRule logger = new PerformanceLoggerRule();

    @Test
    public void shouldLogPerformance() throws InterruptedException {
        Thread.sleep(10);
    }
}
