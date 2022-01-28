package ru.netology.model.comment

import org.junit.Assert.assertEquals
import org.junit.Test

class CommentThreadTest {

    @Test
    fun test_commentThread_defaults() {
        val commentThread = CommentThread()
        assertEquals(0L, commentThread.count)
        assertEquals(arrayListOf<Comment>(), commentThread.items)
        assertEquals(false, commentThread.canPost)
        assertEquals(false, commentThread.showReplyButton)
        assertEquals(false, commentThread.groupsCanPost)
    }
}