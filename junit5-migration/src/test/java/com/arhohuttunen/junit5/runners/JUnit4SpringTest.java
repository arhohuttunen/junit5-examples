package com.arhohuttunen.junit5.runners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfiguration.class)
public class JUnit4SpringTest {

    @Test
    public void shouldLoadSpringContext() {

    }
}
