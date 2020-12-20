package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupingAssertions {

    @Test
    void firstAndLastNameMatches() {
        Person person = new Person("John", "Doe");

        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }
}
