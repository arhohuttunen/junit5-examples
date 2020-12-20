package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgumentsSourceTest {

    @ParameterizedTest
    @ArgumentsSource(PalindromesProvider.class)
    void externalPalindromeMethodSource(String string) {
        assertTrue(StringUtils.isPalindrome(string));
    }
}
