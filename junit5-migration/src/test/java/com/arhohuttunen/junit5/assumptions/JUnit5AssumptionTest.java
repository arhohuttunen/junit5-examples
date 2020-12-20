package com.arhohuttunen.junit5.assumptions;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class JUnit5AssumptionTest {

    @Test
    void shouldOnlyRunInDevelopmentEnvironment() {
        Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting: not on developer workstation");
    }
}
