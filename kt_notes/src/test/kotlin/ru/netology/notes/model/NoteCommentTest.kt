package ru.netology.notes.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

internal class NoteCommentTest {

    @Test
    fun test_comment_defaults() {
        val nid = 0L
        val uid = 0L
        val oid = 0L
        val replyTo = 0L
        val date = LocalDateTime.now()
        val message = "comment"
        val guid = "guid"

        val noteComment = Comment(
            nid = nid,
            uid = uid,
            oid = oid,
            replyTo = replyTo,
            date = date,
            message = message,
            guid = guid,
        )

        assertEquals(-1L, noteComment.id)
        assertEquals(nid, noteComment.nid)
        assertEquals(uid, noteComment.uid)
        assertEquals(oid, noteComment.oid)
        assertEquals(date, noteComment.date)
        assertEquals(message, noteComment.message)
        assertEquals(replyTo, noteComment.replyTo)
        assertEquals(guid, noteComment.guid)
        assertEquals(false, noteComment.isRemoved)
    }
}