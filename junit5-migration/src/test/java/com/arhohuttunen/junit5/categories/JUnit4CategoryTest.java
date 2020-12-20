package com.arhohuttunen.junit5.categories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class JUnit4CategoryTest {

    @Test
    public void testMethod() {
        Assert.assertEquals(3, 1 + 2);
    }
}
