package ru.netology.notes.service

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import ru.netology.notes.exception.NotesException
import ru.netology.notes.model.Note
import ru.netology.notes.repository.Repository
import java.time.LocalDateTime

class NoteImplTest {

    private val repository = mockk<Repository<Note>>(relaxed = true)
    private val service = NoteImpl(repository)

    private val id = 0L
    private val ownerId = 0L
    private val title = "title"
    private val text = "text"
    private val date = LocalDateTime.now()
    private val privacyView = emptyList<String>()
    private val privacyComment = emptyList<String>()

    private val note = Note(
        id = id,
        ownerId = ownerId,
        title = title,
        text = text,
        date = date,
        privacyView = privacyView,
        privacyComment = privacyComment,
    )

    @Test
    fun test_add_expected() {
        val defaultId = -1L
        val note1 = note.copy(id = defaultId, text = "note1")
        val note2 = note.copy(id = defaultId, text = "note2")

        every { repository.save(note1.copy(id = 0L)) } returns note1.copy(id = 0L)
        every { repository.save(note2.copy(id = 1L)) } returns note2.copy(id = 1L)

        assertEquals(note1.copy(id = 0L), service.add(note1))
        assertEquals(note2.copy(id = 1L), service.add(note2))
    }

    @Test
    fun test_read_expected() {
        every { repository.findById(note.id) } returns note

        assertEquals(note, service.read(note.id))
    }

    @Test
    fun test_read_expected_exception() {
        val wrongId = Long.MAX_VALUE
        val deletedComment = note.copy(isRemoved = true)

        every { repository.findById(wrongId) } returns deletedComment
        try {
            service.read(wrongId)
            Assert.fail("Exception expected")
        } catch (e: NotesException) {
            assertEquals("Note is removed!", e.message)
        }
    }

    @Test
    fun test_readHidden_expected() {
        every { repository.findById(note.id) } returns note

        assertEquals(note, service.readHidden(note.id))
    }

    @Test
    fun test_readHidden_expected_exception() {
        val wrongId = Long.MAX_VALUE

        every { repository.findById(wrongId) } returns null

        try {
            service.readHidden(wrongId)
            Assert.fail("Exception expected")
        } catch (e: NotesException) {
            assertEquals("Note not found!", e.message)
        }
    }

    @Test
    fun test_update_expected() {
        every { repository.save(note) } returns note
        assertEquals(note, service.update(note))
    }

    @Test
    fun test_delete_expected() {
        val removed = note.copy(isRemoved = true)

        every { repository.save(removed) } returns removed
        every { repository.delete(note) }

        assertEquals(removed, service.delete(note))
    }

    @Test
    fun test_restore_expected() {
        val restored = note.copy(isRemoved = false)

        every { repository.save(restored) } returns restored

        assertEquals(restored, service.restore(note))
    }

    @Test
    fun test_readAll_expected() {
        val comment2 = note.copy(id = 1L)

        val comment3 = note.copy(id = 2L, isRemoved = true)
        val comment4 = note.copy(id = 3L, isRemoved = true)

        val ids = listOf(note.id, note.id)
        every { repository.findAllByIds(ids) } returns sequenceOf(note, comment2, comment3, comment4)

        val expected = listOf(note, comment2)
        val result = service.readAll(ids).toList()

        assertEquals(expected, result)
        assertFalse(result.contains(comment3))
        assertFalse(result.contains(comment4))
    }
}
