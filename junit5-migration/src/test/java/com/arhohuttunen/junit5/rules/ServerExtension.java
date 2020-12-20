package com.arhohuttunen.junit5.rules;

import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ServerExtension implements BeforeAllCallback, AfterAllCallback {
    private Server server = new Server(9000);

    public Server getServer() {
        return server;
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        server.start();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        server.stop();
    }
}
