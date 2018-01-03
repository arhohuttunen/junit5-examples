package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class EnumSourceParameterTest {

    private WebServer webServer = new WebServer();

    @ParameterizedTest
    @EnumSource(Protocol.class)
    void postRequestWithDifferentProtocols(Protocol protocol) {
        webServer.postRequest(protocol);
    }

    enum Protocol {
        HTTP_1_0, HTTP_1_1, HTTP_2
    }

    static class WebServer {
        public void postRequest(Protocol protocol) {
            // Do nothing
        }
    }
}
