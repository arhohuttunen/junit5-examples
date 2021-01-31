package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `1 + 2 = 3`() {
        assertEquals(3, calculator.add(1, 2)) {
            "1 + 2 should equal 3"
        }
    }

    @Test
    fun `Divide by zero should throw ArithmeticException`() {
        assertThrows<ArithmeticException> {
            calculator.divide(1, 0)
        }
    }

    @Test
    fun `Square of a number should equal the number multiplied by itself`() {
        assertAll(
                { assertEquals(1, calculator.square(1)) },
                { assertEquals(4, calculator.square(2)) },
                { assertEquals(9, calculator.square(3)) }
        )
    }
}
