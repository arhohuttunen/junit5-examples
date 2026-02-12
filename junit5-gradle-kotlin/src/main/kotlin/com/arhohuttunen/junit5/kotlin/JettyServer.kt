package com.arhohuttunen.junit5.kotlin

import org.eclipse.jetty.ee10.servlet.ServletContextHandler
import org.eclipse.jetty.server.Connector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.ServerConnector
import java.net.URI

class JettyServer {
    private lateinit var server: Server

    val uri: URI
        get() = server.uri

    fun start() {
        server = Server()
        val connector = ServerConnector(server)
        server.connectors = arrayOf<Connector>(connector)
        val context = ServletContextHandler()
        context.contextPath = "/"
        context.addServlet(JettyServlet::class.java, "/status")
        server.handler = context
        server.start()
    }

    fun stop() {
        server.stop()
    }
}