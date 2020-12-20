package com.arhohuttunen.junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class NestedLifecycleTest {
    @Nested
    class HappyPath {
        @BeforeEach
        void beforeEachHappyPath() {
            System.out.println("Before each happy path");
        }

        @AfterEach
        void afterEachHappyPath() {
            System.out.println("After each happy path");
        }

        @Test
        void happyPathOne() {
            System.out.println("Happy path one");
        }

        @Test
        void happyPathTwo() {
            System.out.println("Happy path two");
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ExceptionalPath {
        @BeforeAll
        void beforeEntireExceptionalPath() {
            System.out.println("Before entire exceptional path");
        }

        @AfterAll
        void afterEntireExceptionalPath() {
            System.out.println("After entire exceptional path");
        }

        @Test
        void exceptionalPathOne() {
            System.out.println("Exceptional path one");
        }

        @Test
        void exceptionalPathTwo() {
            System.out.println("Exceptional path two");
        }
    }
}
