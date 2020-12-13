package com.codingrevolution.junit5.rules;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

@EnableRuleMigrationSupport
class JUnit5ExpectedExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void ruleCatchesThrownExceptionAndMessage() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Wrong argument");

        throw new IllegalArgumentException("Wrong argument!");
    }

    @Test
    void catchThrownExceptionAndMessage() {
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Wrong argument!");
        });

        Assertions.assertEquals("Wrong argument!", thrown.getMessage());
    }
}
