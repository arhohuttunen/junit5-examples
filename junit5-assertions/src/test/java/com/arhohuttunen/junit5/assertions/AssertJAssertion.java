package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AssertJAssertion {

    @Test
    void listHasPerson() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe"));
        people.add(new Person("Jane", "Doe"));
        assertThat(people).extracting("firstName").contains("John");
    }
}
