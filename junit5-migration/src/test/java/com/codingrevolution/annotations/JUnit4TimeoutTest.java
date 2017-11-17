package com.codingrevolution.annotations;

import org.junit.Test;

public class JUnit4TimeoutTest {

    @Test(timeout = 1)
    public void shouldTimeout() throws InterruptedException {
        Thread.sleep(5);
    }
}
