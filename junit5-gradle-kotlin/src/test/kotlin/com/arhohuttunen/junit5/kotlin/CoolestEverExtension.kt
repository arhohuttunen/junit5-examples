package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class CoolestEverExtension : BeforeAllCallback, AfterAllCallback {
    override fun beforeAll(context: ExtensionContext) {
        println("Coolest ever extension: before all")
    }

    override fun afterAll(context: ExtensionContext) {
        println("Coolest ever extension: after all")
    }
}
