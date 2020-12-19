package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvSourceParameterTest {

    @ParameterizedTest(name = "{index} => arabic={0}, roman={1}")
    @CsvSource({"1, I", "2, II", "3, III", "4, IV", "5, V", "10, X"})
    void convertArabicToRomanNumeral(int arabic, String roman) {
        assertEquals(roman, new RomanNumeral(arabic).toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"John, "})
    void nullArgument(String name, String address) {
        assertNull(address);
    }

    @ParameterizedTest
    @CsvSource({"John, ''"})
    void emptyArgument(String name, String address) {
        assertTrue(address.isEmpty());
    }

    @ParameterizedTest
    @CsvSource(value = {"Jane, NULL"}, nullValues = "NULL")
    void customNullArgument(String name, String address) {
        assertNull(address);
    }

    @ParameterizedTest
    @CsvSource(value = {"John, ''"}, emptyValue = "BLANK")
    void emptyDefaultArgument(String task, String address) {
        assertEquals("BLANK", address);
    }
}
