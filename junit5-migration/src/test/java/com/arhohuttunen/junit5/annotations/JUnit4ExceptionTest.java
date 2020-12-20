package com.arhohuttunen.junit5.annotations;

import org.junit.Test;

public class JUnit4ExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnException() {
        throw new IllegalArgumentException();
    }
}
