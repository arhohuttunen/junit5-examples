package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueSourceParameterTest {

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void palindromeReadsSameBackward(String string) {
        assertEquals(string, isPalindrome(string));
    }

    private String isPalindrome(String string) {
        return new StringBuilder(string).reverse().toString();
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
