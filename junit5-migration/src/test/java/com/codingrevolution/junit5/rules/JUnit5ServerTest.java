package com.codingrevolution.junit5.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class JUnit5ServerTest {
    @RegisterExtension
    static ServerExtension extension = new ServerExtension();

    @Test
    void serverIsRunning() {
        Assertions.assertTrue(extension.getServer().isRunning());
    }
}
