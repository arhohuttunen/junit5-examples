package com.arhohuttunen.junit5.annotations;

import org.junit.Ignore;
import org.junit.Test;

public class JUnit4TimeoutTest {

    @Test(timeout = 1)
    @Ignore("This would fail the build, so the test is ignored")
    public void shouldTimeout() throws InterruptedException {
        Thread.sleep(5);
    }
}
