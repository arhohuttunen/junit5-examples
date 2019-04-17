package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualityAssertion {

    @Test
    void addNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    void personsAreSame() {
        Person john = new Person("John", "Doe");
        Person doe = new Person("John", "Doe");

        assertEquals(john, doe);
    }
}
