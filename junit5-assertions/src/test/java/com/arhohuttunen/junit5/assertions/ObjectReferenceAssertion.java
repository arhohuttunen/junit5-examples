package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class ObjectReferenceAssertion {

    @Test
    void personsAreNotSameInstance() {
        Person john = new Person("John", "Doe");
        Person doe = new Person("John", "Doe");

        assertNotSame(john, doe);
    }
}
