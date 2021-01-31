package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ParameterResolver
import org.junit.jupiter.api.extension.RegisterExtension
import java.net.HttpURLConnection

class RegisterStaticExtensionTest {
    companion object {
        /**
         * A better way to provide parameters for the test method would be to make the extension implement the
         * [ParameterResolver] interface. However, this example is here to demonstrate the usage of [JvmField].
         */
        @JvmField
        @RegisterExtension
        val jettyExtension: JettyExtension = JettyExtension()
    }

    @Test
    fun `use randomized port from extension`() {
        val url = jettyExtension.serverUri.resolve("/status").toURL()
        val connection = url.openConnection() as HttpURLConnection
        val response = connection.responseCode

        Assertions.assertEquals(200, response)
    }
}