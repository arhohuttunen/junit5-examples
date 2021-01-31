package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.net.URI

class JettyExtension : BeforeAllCallback, AfterAllCallback {
    private val jettyServer = JettyServer()

    val serverUri: URI
        get() = jettyServer.uri

    override fun beforeAll(context: ExtensionContext?) {
        jettyServer.start()
    }

    override fun afterAll(context: ExtensionContext?) {
        jettyServer.stop()
    }
}