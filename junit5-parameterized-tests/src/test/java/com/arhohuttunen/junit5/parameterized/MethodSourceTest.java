package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MethodSourceTest {

    @ParameterizedTest
    @MethodSource("palindromesProvider")
    void palindromeReadsSameBackward(String string) {
        assertTrue(StringUtils.isPalindrome(string));
    }

    private static Stream<String> palindromesProvider() {
        return Stream.of("level", "madam", "saippuakivikauppias");
    }

    @ParameterizedTest
    @MethodSource
    void monthNames(int month, String name) {
        assertEquals(name, DateUtils.getMonthName(month));
    }

    private static Stream<Arguments> monthNames() {
        return Stream.of(
                arguments(1, "January"),
                arguments(2, "February"),
                arguments(12, "December")
        );
    }
}
