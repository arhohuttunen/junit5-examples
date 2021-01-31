package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SecondBestExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        println("Second best extension - before each")
    }

    override fun afterEach(context: ExtensionContext) {
        println("Second best extension - after each")
    }
}
