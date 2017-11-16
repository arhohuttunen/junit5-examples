package com.codingrevolution.junit4;

import org.junit.Test;

public class TimeoutTest {

    @Test(timeout = 1)
    public void shouldTimeout() throws InterruptedException {
        Thread.sleep(5);
    }
}
