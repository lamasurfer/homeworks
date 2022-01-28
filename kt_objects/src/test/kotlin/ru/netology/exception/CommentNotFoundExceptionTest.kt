package ru.netology.exception

import org.junit.Assert.assertEquals
import org.junit.Test

class CommentNotFoundExceptionTest {

    @Test
    fun test_commentNotFoundException_defaults() {
        val e = CommentNotFoundException()
        assertEquals("Comment not found!", e.message)
    }
}