package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomAssertionErrorMessage {

    @Test
    void addNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1, 2), "1 + 2 should equal 3");
    }

    @Test
    void addingEmployeesToPersonnel() {
        Person employee = new Person("John", "Doe");

        Set<Person> personnel = new HashSet<>();
        personnel.add(employee);

        assertTrue(personnel.contains(employee),
                () -> String.format("Personnel file for %s was not found", employee));
    }
}
