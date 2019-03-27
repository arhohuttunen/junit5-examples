package com.codingrevolution.junit5.runners;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class JUnit5MockitoTest {

    @InjectMocks
    private Example example;

    @Mock
    private Dependency dependency;

    @Test
    void shouldInjectMocks() {
        example.doSomething();
        verify(dependency).doSomethingElse();
    }
}
