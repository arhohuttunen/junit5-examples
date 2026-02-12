package com.arhohuttunen.junit5.assertions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class JUnit4HamcrestTest {

    @Test
    public void numbersNotEqual() {
        assertThat("numbers 1 and 2 are not equal", 1, is(not(equalTo(2))));
    }
}
