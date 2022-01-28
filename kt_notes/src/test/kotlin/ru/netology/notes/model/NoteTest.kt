package ru.netology.notes.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

internal class NoteTest {

    @Test
    fun test_note_defaults() {
        val ownerId = 0L
        val title = "title"
        val text = "text"
        val date = LocalDateTime.now()
        val note = Note(
            ownerId = ownerId,
            title = title,
            text = text,
            date = date,
        )
        assertEquals(-1L, note.id)
        assertEquals(ownerId, note.ownerId)
        assertEquals(title, note.title)
        assertEquals(text, note.text)
        assertEquals(date, note.date)
        assertEquals(0L, note.comments)
        assertEquals(0L, note.readComments)
        assertEquals("note", note.viewUrl)
        assertEquals(emptyList<String>(), note.privacyView)
        assertEquals(emptyList<String>(), note.privacyComment)
        assertEquals(true, note.canComment)
        assertEquals("", note.textWiki)
        assertEquals(false, note.isRemoved)
    }
}