package com.codingrevolution.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class TruthAssertion {

    @Test
    void listHasItemsInOrder() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Citron");
        fruits.add("Grapefruit");
        fruits.add("Orange");
        assertThat(fruits).containsExactly("Citron", "Grapefruit", "Orange").inOrder();
    }
}
