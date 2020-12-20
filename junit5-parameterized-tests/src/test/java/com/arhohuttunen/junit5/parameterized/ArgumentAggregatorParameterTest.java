package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

class ArgumentAggregatorParameterTest {
    @ParameterizedTest
    @CsvSource({
        "Write a blog post, IN_PROGRESS, 2020-12-20",
        "Wash the car, OPENED, 2020-12-15"
    })
    void aggregateArgumentsWithAggregator(@AggregateWith(TaskAggregator.class) Task task) {
        System.out.println(task);
    }

    @ParameterizedTest
    @CsvSource({
            "Write a blog post, IN_PROGRESS, 2020-12-20",
            "Wash the car, OPENED, 2020-12-15"
    })
    void aggregateArgumentsWithAnnotation(@CsvToTask Task task) {
        System.out.println(task);
    }
}
