package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvFileSourceParameterTest {

    @ParameterizedTest(name = "{index} => arabic={0}, roman={1}")
    @CsvFileSource(resources = "/roman-numeral.csv")
    void convertArabicToRomanNumeral(int arabic, String roman) {
        assertEquals(roman, new RomanNumeral(arabic).toString());
    }
}
