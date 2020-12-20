package com.arhohuttunen.junit5.assertions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class HamcrestAssertion {

    @Test
    void listHasOneItem() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        assertThat(list, hasSize(1));
    }
}
