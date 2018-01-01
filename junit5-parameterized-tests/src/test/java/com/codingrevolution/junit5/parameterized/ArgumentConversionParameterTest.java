package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class ArgumentConversionParameterTest {

    @ParameterizedTest
    @CsvSource({
            "15, F",
            "16, 10",
            "233, E9"
    })
    void convertWithCustomHexConverter(int expected, @ConvertWith(HexConverter.class) int actual) {
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10, A",
            "31, 1F",
            "256, 100"
    })
    void convertWithCustomHexValueAnnotation(int expected, @HexValue int actual) {
        Assertions.assertEquals(expected, actual);
    }
}
