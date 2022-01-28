package ru.netology.model.post

import org.junit.Assert.assertEquals
import org.junit.Test

class CommentsTest {

    @Test
    fun test_comments_defaults() {
        val comments = Comments()
        assertEquals(0L, comments.count)
        assertEquals(false, comments.canPost)
        assertEquals(false, comments.groupsCanPost)
        assertEquals(false, comments.canClose)
        assertEquals(false, comments.canOpen)
    }
}