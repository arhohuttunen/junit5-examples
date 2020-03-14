package com.codingrevolution.junit5.rules;

import org.junit.Assert;
import org.junit.Test;

public class JUnit4ServerInheritedTest extends JUnit4ServerBaseTest {
    @Test
    public void serverIsRunning() {
        Assert.assertTrue(server.isRunning());
    }
}
