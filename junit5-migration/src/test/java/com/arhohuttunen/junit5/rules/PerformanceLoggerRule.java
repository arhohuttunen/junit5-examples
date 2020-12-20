package com.arhohuttunen.junit5.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PerformanceLoggerRule implements TestRule {

    private long testStart;
    private String testName;

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                testStart = System.currentTimeMillis();
                testName = description.getMethodName();

                base.evaluate();

                System.out.printf("%s executed in %d ms\n",
                        testName, (System.currentTimeMillis() - testStart));
            }
        };
    }
}
