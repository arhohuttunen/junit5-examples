package com.codingrevolution.junit5;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class AssumptionTest {

    @Test
    void shouldOnlyRunInDevelopmentEnvironment() {
        Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting: not on developer workstation");
    }
}
