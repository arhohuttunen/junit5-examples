package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.time.LocalDate;

public class TaskAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        return new Task(
                accessor.getString(0),
                accessor.get(1, Task.Status.class),
                accessor.get(2, LocalDate.class)
        );
    }
}
