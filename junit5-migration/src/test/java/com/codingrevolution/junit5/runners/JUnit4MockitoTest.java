package com.codingrevolution.junit5.runners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class JUnit4MockitoTest {

    @InjectMocks
    private Example example;

    @Mock
    private Dependency dependency;

    @Test
    public void shouldInjectMocks() {
        example.doSomething();
        verify(dependency).doSomethingElse();
    }
}
