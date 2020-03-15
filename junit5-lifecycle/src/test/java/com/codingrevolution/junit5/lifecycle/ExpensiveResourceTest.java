package com.codingrevolution.junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExpensiveResourceTest {
    private JettyServer jettyServer;

    @BeforeAll
    void startServer() throws Exception {
        jettyServer = new JettyServer();
        jettyServer.start();
    }

    @AfterAll
    void stopServer() throws Exception {
        jettyServer.stop();
    }

    @Test
    void checkServerStatus() throws IOException {
        URL url = new URL("http://localhost:8080/status");
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        int response = connection.getResponseCode();

        assertEquals(200, response);
    }

    @Test
    void checkInvalidUrl() throws IOException {
        URL url = new URL("http://localhost:8080/invalid");
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        int response = connection.getResponseCode();

        assertEquals(404, response);
    }
}
