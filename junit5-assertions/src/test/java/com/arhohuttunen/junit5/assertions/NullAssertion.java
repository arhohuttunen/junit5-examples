package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullAssertion {

    @Test
    void personHasFirstName() {
        Person person = new Person("John", "Doe");
        assertNotNull(person.firstName());
    }
}
