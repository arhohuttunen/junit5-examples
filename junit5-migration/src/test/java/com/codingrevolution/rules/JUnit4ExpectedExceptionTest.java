package com.codingrevolution.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JUnit4ExpectedExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWithMessage() {
        thrown.expectMessage("Wrong argument");

        throw new IllegalArgumentException("Wrong argument!");
    }
}
