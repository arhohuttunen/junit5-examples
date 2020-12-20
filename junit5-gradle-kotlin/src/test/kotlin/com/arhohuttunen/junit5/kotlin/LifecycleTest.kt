package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LifecycleTest {
    @BeforeAll
    fun beforeAll() {
        println("Before all")
    }

    @AfterAll
    fun afterAll() {
        println("After all")
    }

    @Test
    fun firstTest() {
        println("First test")
    }

    @Test
    fun secondTest() {
        println("Second test")
    }
}
