package com.arhohuttunen.junit5.parameterized;

import com.arhohuttunen.junit5.parameterized.Task.Status;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

class CsvFileSourceParameterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/tasks.csv", numLinesToSkip = 1)
    void readTasks(String title, Status status, LocalDate date) {
        System.out.printf("%s, %s, %s", title, status, date);
    }
}
