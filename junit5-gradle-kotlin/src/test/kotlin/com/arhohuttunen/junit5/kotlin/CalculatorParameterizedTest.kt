package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorParameterizedTest {

    private val calculator = Calculator()

    companion object {
        @JvmStatic
        fun squares() = listOf(
                Arguments.of(1, 1),
                Arguments.of(2, 4),
                Arguments.of(3, 9)
        )
    }

    @ParameterizedTest(name = "Square of {0} should equal {1}")
    @MethodSource("squares")
    fun `Square of a number`(input: Int, expected: Int) {
        assertEquals(expected, calculator.square(input))
    }
}