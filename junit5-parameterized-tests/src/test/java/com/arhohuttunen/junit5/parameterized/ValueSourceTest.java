package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueSourceTest {

    @ParameterizedTest
    @ValueSource(strings = { "level", "madam", "saippuakivikauppias" })
    void palindromeReadsSameBackward(String string) {
        assertTrue(StringUtils.isPalindrome(string));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 6, 15 })
    void divisibleByThree(int number) {
        assertEquals(0, number % 3);
    }

    @ParameterizedTest(name = "[{index}] \"{0}\"")
    @NullSource
    @EmptySource
    @ValueSource(strings = { " " })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }
}
