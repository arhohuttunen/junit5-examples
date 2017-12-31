package com.codingrevolution.junit5.rules;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

@EnableRuleMigrationSupport
class JUnit5ExpectedExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void shouldThrowExceptionWithMessage() {
        thrown.expectMessage("Wrong argument");

        throw new IllegalArgumentException("Wrong argument!");
    }
}
