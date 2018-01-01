package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceParameterTest {

    @ParameterizedTest(name = "{index} => arabic={0}, roman={1}")
    @CsvSource({"1, I", "2, II", "3, III", "4, IV", "5, V", "10, X"})
    void convertArabicToRomanNumeral(int arabic, String roman) {
        Assertions.assertEquals(roman, new RomanNumeral(arabic).toString());
    }
}
