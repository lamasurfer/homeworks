package ru.netology.model.comment

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.model.post.attachment.Attachment

class CommentTest {

    @Test
    fun test_comment_defaults() {
        val comment = Comment()
        assertEquals(0L, comment.id)
        assertEquals(0L, comment.postId)
        assertEquals(0L, comment.fromId)
        assertEquals(0L, comment.date)
        assertEquals("", comment.text)
        assertEquals(CommentDonut(), comment.donut)
        assertEquals(0L, comment.replyToUser)
        assertEquals(0L, comment.replyToComment)
        assertEquals(arrayListOf<Attachment>(), comment.attachments)
        assertEquals(arrayListOf<Long>(), comment.parentsStack)
        assertEquals(CommentThread(), comment.thread)
    }
}