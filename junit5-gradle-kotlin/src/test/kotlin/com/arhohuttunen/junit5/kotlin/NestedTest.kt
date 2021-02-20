package com.arhohuttunen.junit5.kotlin

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NestedTest {
    @Nested
    @DisplayName("GET /entity")
    inner class GetRequest {
        @Test
        fun `return existing entity`() {

        }
    }

    @Nested
    @DisplayName("POST /entity")
    inner class PostRequest {
        @Test
        fun `create new entity`() {

        }
    }
}
