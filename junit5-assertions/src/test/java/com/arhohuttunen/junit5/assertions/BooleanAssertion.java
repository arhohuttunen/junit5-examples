package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BooleanAssertion {

    @Test
    void firstNameStartsWithJ() {
        Person person = new Person("John", "Doe");
        assertTrue(person.getFirstName().startsWith("J"));
    }
}
