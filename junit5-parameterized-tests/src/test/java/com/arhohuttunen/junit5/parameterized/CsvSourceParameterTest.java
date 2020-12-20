package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvSourceParameterTest {

    @ParameterizedTest
    @CsvSource({
            "Write a blog post, IN_PROGRESS, 2020-12-20",
            "Wash the car, OPENED, 2020-12-15"
    })
    void readTasks(String title, Task.Status status, LocalDate date) {
        System.out.printf("%s, %s, %s", title, status, date);
    }

    @ParameterizedTest
    @CsvSource(", IN_PROGRESS, 2020-12-20")
    void nullArgument(String title, Task.Status status, LocalDate date) {
        assertNull(title);
    }

    @ParameterizedTest
    @CsvSource("'', IN_PROGRESS, 2020-12-20")
    void emptyArgument(String title, Task.Status status, LocalDate date) {
        assertTrue(title.isEmpty());
    }

    @ParameterizedTest
    @CsvSource(value = "NULL, IN_PROGRESS, 2020-12-20", nullValues = "NULL")
    void customNullArgument(String title, Task.Status status, LocalDate date) {
        assertNull(title);
    }

    @ParameterizedTest
    @CsvSource(value = "'', IN_PROGRESS, 2020-12-20", emptyValue = "BLANK")
    void emptyDefaultArgument(String title, Task.Status status, LocalDate date) {
        assertEquals("BLANK", title);
    }
}
