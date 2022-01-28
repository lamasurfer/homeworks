package ru.netology.notes.service

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import ru.netology.notes.exception.NotesException
import ru.netology.notes.model.Comment
import ru.netology.notes.repository.Repository
import java.time.LocalDateTime

class CommentImplTest {

    private val repository = mockk<Repository<Comment>>(relaxed = true)
    private val service = CommentImpl(repository)

    private val id = 0L
    private val nid = 0L
    private val uid = 0L
    private val oid = 0L
    private val replyTo = 0L
    private val date = LocalDateTime.now()
    private val message = "comment"
    private val guid = "guid"

    private val comment = Comment(
        id = id,
        nid = nid,
        uid = uid,
        oid = oid,
        replyTo = replyTo,
        date = date,
        message = message,
        guid = guid,
        isRemoved = false,
    )

    @Test
    fun test_add_expected() {
        val defaultId = -1L
        val note1 = comment.copy(id = defaultId, message = "comment1")
        val note2 = comment.copy(id = defaultId, message = "comment2")

        every { repository.save(note1.copy(id = 0L)) } returns note1.copy(id = 0L)
        every { repository.save(note2.copy(id = 1L)) } returns note2.copy(id = 1L)

        assertEquals(note1.copy(id = 0L), service.add(note1))
        assertEquals(note2.copy(id = 1L), service.add(note2))
    }

    @Test
    fun test_read_expected() {
        every { repository.findById(comment.id) } returns comment

        assertEquals(comment, service.read(comment.id))
    }

    @Test
    fun test_read_expected_exception() {
        val wrongId = Long.MAX_VALUE
        val deletedComment = comment.copy(isRemoved = true)

        every { repository.findById(wrongId) } returns deletedComment
        try {
            service.read(wrongId)
            Assert.fail("Exception expected")
        } catch (e: NotesException) {
            assertEquals("Comment is removed!", e.message)
        }
    }

    @Test
    fun test_readHidden_expected() {
        every { repository.findById(comment.id) } returns comment

        assertEquals(comment, service.readHidden(comment.id))
    }

    @Test
    fun test_readHidden_expected_exception() {
        val wrongId = Long.MAX_VALUE

        every { repository.findById(wrongId) } returns null

        try {
            service.readHidden(wrongId)
            Assert.fail("Exception expected")
        } catch (e: NotesException) {
            assertEquals("Comment not found!", e.message)
        }
    }

    @Test
    fun test_update_expected() {
        every { repository.save(comment) } returns comment
        assertEquals(comment, service.update(comment))
    }

    @Test
    fun test_delete_expected() {
        val removed = comment.copy(isRemoved = true)

        every { repository.save(removed) } returns removed
        every { repository.delete(comment) }

        assertEquals(removed, service.delete(comment))
    }

    @Test
    fun test_restore_expected() {
        val restored = comment.copy(isRemoved = false)

        every { repository.save(restored) } returns restored

        assertEquals(restored, service.restore(comment))
    }

    @Test
    fun test_readAll_expected() {
        val comment2 = comment.copy(id = 1L)

        val comment3 = comment.copy(id = 2L, isRemoved = true)
        val comment4 = comment.copy(id = 3L, isRemoved = true)

        val ids = listOf(comment.id, comment.id)
        every { repository.findAllByIds(ids) } returns sequenceOf(comment, comment2, comment3, comment4)

        val expected = listOf(comment, comment2)
        val result = service.readAll(ids).toList()

        assertEquals(expected, result)
        assertFalse(result.contains(comment3))
        assertFalse(result.contains(comment4))
    }
}
