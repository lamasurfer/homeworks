package ru.netology.exception

import org.junit.Assert.assertEquals
import org.junit.Test

class PostNotFoundExceptionTest {

    @Test
    fun test_postNotFoundException_defaults() {
        val e = PostNotFoundException()
        assertEquals("Post not found!", e.message)
    }
}