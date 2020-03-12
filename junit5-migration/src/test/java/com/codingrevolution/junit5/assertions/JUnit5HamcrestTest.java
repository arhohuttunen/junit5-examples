package com.codingrevolution.junit5.assertions;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

class JUnit5HamcrestTest {

    @Test
    void numbersNotEqual() {
        MatcherAssert.assertThat("numbers 1 and 2 are not equal", 1, is(not(equalTo(2))));
    }
}
