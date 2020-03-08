package com.codingrevolution.junit5.kotlin

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SecondExtension : BeforeAllCallback, AfterAllCallback {
    override fun beforeAll(context: ExtensionContext) {
        println("Before all")
    }

    override fun afterAll(context: ExtensionContext) {
        println("After all")
    }
}
