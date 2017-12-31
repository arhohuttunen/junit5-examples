package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileSourceParameterTest {

    @ParameterizedTest(name = "arabic={0}, roman={1}")
    @CsvFileSource(resources = "/roman-numeral.csv")
    void convertArabicToRomanNumeral(int arabic, String roman) {
        Assertions.assertEquals(roman, new RomanNumeral(arabic).toString());
    }
}
