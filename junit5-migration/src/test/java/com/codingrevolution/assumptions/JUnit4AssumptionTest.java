package com.codingrevolution.assumptions;

import org.junit.Assume;
import org.junit.Test;

public class JUnit4AssumptionTest {

    @Test
    public void shouldOnlyRunInDevelopmentEnvironment() {
        Assume.assumeTrue("Aborting: not on developer workstation",
                "DEV".equals(System.getenv("ENV")));
    }
}
