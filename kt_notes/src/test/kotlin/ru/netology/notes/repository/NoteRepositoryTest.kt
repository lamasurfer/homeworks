package ru.netology.notes.repository

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.notes.model.Note
import java.time.LocalDateTime

internal class NoteRepositoryTest {

    private val repo = RepositoryImpl<Note>()

    private val id = 0L
    private val ownerId = 0L
    private val title = ""
    private val text = "note1"
    private val date = LocalDateTime.now()
    private val comments = 0L
    private val readComments = 0L
    private val viewUrl = ""
    private val privacyView: List<String> = arrayListOf()
    private val privacyComment: List<String> = arrayListOf()
    private val canComment: Boolean = true
    private val textWiki: String = ""

    private val note = Note(
        id = id,
        ownerId = ownerId,
        title = title,
        text = text,
        date = date,
        comments = comments,
        readComments = readComments,
        viewUrl = viewUrl,
        privacyView = privacyView,
        privacyComment = privacyComment,
        canComment = canComment,
        textWiki = textWiki,
    )

    @Before
    fun init() {
        repo.deleteAll()
    }

    @Test
    fun test_save_expected() {
        val note2 = note.copy(id = 1L, text = "note2")


        assertEquals(note, repo.save(note))
        assertEquals(note2, repo.save(note2))
    }

    @Test
    fun test_findAll_expected() {
        val note2 = note.copy(id = 1L, text = "note2")
        val note3 = note.copy(id = 2L, text = "note3")

        repo.save(note)
        repo.save(note2)
        repo.save(note3)

        val list = listOf(note, note2, note3)

        assertEquals(list, repo.findAll().toList())
    }

    @Test
    fun test_count_expected() {
        val note2 = note.copy(id = 1L, text = "note2")
        val note3 = note.copy(id = 2L, text = "note3")

        repo.save(note)
        repo.save(note2)
        repo.save(note3)

        val expected = 3L
        assertEquals(expected, repo.count())
    }

    @Test
    fun test_findById_expected() {

        val expected = repo.save(note)

        assertEquals(expected, repo.findById(expected.id))

        val notFound = repo.findById(Long.MAX_VALUE)
        assertNull(notFound)
    }

    @Test
    fun test_existsById_expected() {

        val saved = repo.save(note)
        val notSaved = note.copy(id = Long.MAX_VALUE)

        assertTrue(repo.existsById(saved.id))
        assertFalse(repo.existsById(notSaved.id))
    }

    @Test
    fun test_deleteById_expected() {
        val note2 = note.copy(id = 1L, text = "note2")

        val toDelete = repo.save(note)
        val notToDelete = repo.save(note2)

        repo.deleteById(toDelete.id)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }

    @Test
    fun test_deleteAll_expected() {
        val note2 = note.copy(id = 1L, text = "note2")

        val toDelete1 = repo.save(note)
        val toDelete2 = repo.save(note2)

        repo.deleteAll()

        assertFalse(repo.existsById(toDelete1.id))
        assertFalse(repo.existsById(toDelete2.id))
    }

    @Test
    fun findAllByIds_expected() {
        val note2 = note.copy(id = 1L, text = "note2")
        val note3 = note.copy(id = 2L, text = "note3")

        repo.save(note)
        repo.save(note2)

        val resultTrue = repo.findAllByIds(listOf(note.id, note2.id)).toList()
        val resultFalse = repo.findAllByIds(listOf(note3.id)).toList()

        assertTrue(resultTrue.contains(note))
        assertTrue(resultTrue.contains(note2))
        assertFalse(resultFalse.contains(note3))
    }

    @Test
    fun delete_expected() {
        val note2 = note.copy(id = 1L, text = "note2")

        val toDelete = repo.save(note)
        val notToDelete = repo.save(note2)

        repo.delete(toDelete)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }
}