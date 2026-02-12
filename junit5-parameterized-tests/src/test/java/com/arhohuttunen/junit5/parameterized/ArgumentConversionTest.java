package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArgumentConversionTest {

    @ParameterizedTest
    @ValueSource(strings = { "SECONDS", "MINUTES" })
    void convertStringToEnum(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @ValueSource(strings = { "2018-01-01", "2018-01-31" })
    void convertStringToLocalDate(LocalDate localDate) {
        assertEquals(Month.JANUARY, localDate.getMonth());
    }

    @ParameterizedTest
    @ValueSource(strings = { "01.01.2018", "31.01.2018" })
    void convertStringToLocalDateWithConversionPattern(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate localDate) {
        assertEquals(2018, localDate.getYear());
    }

    @ParameterizedTest
    @CsvSource({
            "15, F",
            "16, 10",
            "233, E9"
    })
    void convertWithCustomHexConverter(int decimal, @ConvertWith(HexConverter.class) Integer hex) {
        assertEquals(decimal, hex);
    }

    @ParameterizedTest
    @CsvSource({
            "10, A",
            "31, 1F",
            "256, 100"
    })
    void convertWithCustomHexValueAnnotation(int decimal, @HexValue Integer hex) {
        assertEquals(decimal, hex);
    }

    @ParameterizedTest
    @CsvSource("John Doe")
    void fallbackStringConversion(Person person) {
        assertEquals("John Doe", person.name());
    }
}
