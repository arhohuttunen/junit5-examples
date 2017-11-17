package com.codingrevolution.annotations;

import org.junit.Test;

public class JUnit4ExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnException() {
        throw new IllegalArgumentException();
    }
}
