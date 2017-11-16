package com.codingrevolution.junit4;

import org.junit.Test;

public class ExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnException() {
        throw new IllegalArgumentException();
    }
}
