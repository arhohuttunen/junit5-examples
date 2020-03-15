package com.codingrevolution.junit5.lifecycle;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(JettyServlet.class, "/status");
        server.setHandler(servletHandler);

        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}
