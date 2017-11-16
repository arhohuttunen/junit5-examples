package com.codingrevolution.junit4;

import org.junit.Assert;
import org.junit.Test;

public class AssertionTest {

    @Test
    public void shouldFailWithMessage() {
        Assert.assertTrue("numbers " + 1 + " and " + 2 + " are not equal", 1 == 2);
    }
}
