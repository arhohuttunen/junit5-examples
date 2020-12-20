package com.codingrevolution.junit5.parameterized;

import com.codingrevolution.junit5.parameterized.Task.Status;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvFileSourceParameterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/tasks.csv", numLinesToSkip = 1)
    void readTasks(String title, Status status, LocalDate date) {
        System.out.printf("%s, %s, %s", title, status, date);
    }

    @ParameterizedTest(name = "{index} => arabic={0}, roman={1}")
    @CsvFileSource(resources = "/roman-numeral.csv")
    void convertArabicToRomanNumeral(int arabic, String roman) {
        assertEquals(roman, new RomanNumeral(arabic).toString());
    }
}
