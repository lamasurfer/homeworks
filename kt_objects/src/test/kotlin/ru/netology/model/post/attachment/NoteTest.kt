package ru.netology.model.post.attachment

import org.junit.Assert.assertEquals
import org.junit.Test

class NoteTest {

    @Test
    fun test_note_defaults() {
        val note = Note()
        assertEquals(0L, note.id)
        assertEquals(0L, note.ownerId)
        assertEquals("", note.title)
        assertEquals("", note.text)
        assertEquals(0L, note.date)
        assertEquals(0L, note.comments)
        assertEquals(0L, note.readComments)
        assertEquals("", note.viewUrl)
        assertEquals(arrayListOf<String>(), note.privacyView)
        assertEquals(arrayListOf<String>(), note.privacyComment)
        assertEquals(false, note.canComment)
        assertEquals("", note.textWiki)
        assertEquals(AttachmentType.NOTE, note.type)
    }
}