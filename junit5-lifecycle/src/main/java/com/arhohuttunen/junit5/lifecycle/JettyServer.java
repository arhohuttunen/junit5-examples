package com.arhohuttunen.junit5.lifecycle;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import java.net.URI;

public class JettyServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();

        try (ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(0);
            server.setConnectors(new Connector[]{connector});
        }

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(JettyServlet.class, "/status");
        server.setHandler(context);

        server.start();
    }

    public URI getURI() {
        return server.getURI();
    }

    public void stop() throws Exception {
        server.stop();
    }
}
