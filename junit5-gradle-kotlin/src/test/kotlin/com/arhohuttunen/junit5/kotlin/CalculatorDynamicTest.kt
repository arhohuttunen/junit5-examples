package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class CalculatorDynamicTest {

    private val calculator = Calculator()

    @TestFactory
    fun `Square of a number`() = listOf(
            1 to 1,
            2 to 4,
            3 to 9
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Square of $input should equal $expected") {
            assertEquals(expected, calculator.square(input))
        }
    }
}