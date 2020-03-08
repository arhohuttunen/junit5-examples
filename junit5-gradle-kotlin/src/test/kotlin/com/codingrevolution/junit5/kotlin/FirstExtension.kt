package com.codingrevolution.junit5.kotlin

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class FirstExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        println("Before each")
    }

    override fun afterEach(context: ExtensionContext) {
        println("After each")
    }
}
