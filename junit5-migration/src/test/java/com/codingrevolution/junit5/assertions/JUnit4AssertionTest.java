package com.codingrevolution.junit5.assertions;

import org.junit.Assert;
import org.junit.Test;

public class JUnit4AssertionTest {

    @Test
    public void shouldFailWithMessage() {
        Assert.assertEquals("numbers " + 1 + " and " + 2 + " are not equal", 1, 2);
    }
}
