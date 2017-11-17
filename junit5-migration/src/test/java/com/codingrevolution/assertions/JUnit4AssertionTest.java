package com.codingrevolution.assertions;

import org.junit.Assert;
import org.junit.Test;

public class JUnit4AssertionTest {

    @Test
    public void shouldFailWithMessage() {
        Assert.assertTrue("numbers " + 1 + " and " + 2 + " are not equal", 1 == 2);
    }
}
