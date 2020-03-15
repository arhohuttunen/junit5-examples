package com.codingrevolution.junit5.lifecycle;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ExtensionOne implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("Before each from " + this.getClass().getSimpleName());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.out.println("After each from " + this.getClass().getSimpleName());
    }
}
