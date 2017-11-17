package com.codingrevolution.junit5;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PerformanceLoggerExtension implements BeforeEachCallback, AfterEachCallback {

    private long testStart;
    private String testName;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        testStart = System.currentTimeMillis();
        testName = context.getDisplayName();
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.printf("%s executed in %d ms\n",
                testName, (System.currentTimeMillis() - testStart));
    }
}
