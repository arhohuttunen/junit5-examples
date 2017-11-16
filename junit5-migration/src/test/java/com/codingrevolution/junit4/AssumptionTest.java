package com.codingrevolution.junit4;

import org.junit.Assume;
import org.junit.Test;

public class AssumptionTest {

    @Test
    public void shouldOnlyRunInDevelopmentEnvironment() {
        Assume.assumeTrue("Aborting: not on developer workstation",
                "DEV".equals(System.getenv("ENV")));
    }
}
