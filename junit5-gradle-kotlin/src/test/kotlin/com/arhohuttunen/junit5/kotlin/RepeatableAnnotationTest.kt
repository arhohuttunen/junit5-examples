package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@Extensions(
        ExtendWith(SecondBestExtension::class),
        ExtendWith(CoolestEverExtension::class)
)
@Tags(
        Tag("fist"),
        Tag("second")
)
class RepeatableAnnotationTest {
    @Test
    fun `multiple extensions and tags`() {
        println("Inside the test")
    }
}
