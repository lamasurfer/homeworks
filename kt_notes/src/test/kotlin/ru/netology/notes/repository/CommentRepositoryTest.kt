package ru.netology.notes.repository

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.notes.model.Comment
import java.time.LocalDateTime

internal class CommentRepositoryTest {

    private val repo = RepositoryImpl<Comment>()

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

    @Before
    fun init() {
        repo.deleteAll()
    }

    @Test
    fun test_save_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")


        assertEquals(comment, repo.save(comment))
        assertEquals(comment2, repo.save(comment2))
    }

    @Test
    fun test_findAll_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")
        val comment3 = comment.copy(id = 2L, message = "comment3")

        repo.save(comment)
        repo.save(comment2)
        repo.save(comment3)

        val list = listOf(comment, comment2, comment3)

        assertEquals(list, repo.findAll().toList())
    }

    @Test
    fun test_count_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")
        val comment3 = comment.copy(id = 2L, message = "comment3")

        repo.save(comment)
        repo.save(comment2)
        repo.save(comment3)

        val expected = 3L
        assertEquals(expected, repo.count())
    }

    @Test
    fun test_findById_expected() {

        val expected = repo.save(comment)

        assertEquals(expected, repo.findById(expected.id))

        val notFound = repo.findById(Long.MAX_VALUE)
        assertNull(notFound)
    }

    @Test
    fun test_existsById_expected() {

        val saved = repo.save(comment)
        val notSaved = comment.copy(id = Long.MAX_VALUE)

        assertTrue(repo.existsById(saved.id))
        assertFalse(repo.existsById(notSaved.id))
    }

    @Test
    fun test_deleteById_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")

        val toDelete = repo.save(comment)
        val notToDelete = repo.save(comment2)

        repo.deleteById(toDelete.id)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }

    @Test
    fun test_deleteAll_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")

        val toDelete1 = repo.save(comment)
        val toDelete2 = repo.save(comment2)

        repo.deleteAll()

        assertFalse(repo.existsById(toDelete1.id))
        assertFalse(repo.existsById(toDelete2.id))
    }

    @Test
    fun findAllByIds_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")
        val comment3 = comment.copy(id = 2L, message = "comment3")

        repo.save(comment)
        repo.save(comment2)

        val resultTrue = repo.findAllByIds(listOf(comment.id, comment2.id)).toList()
        val resultFalse = repo.findAllByIds(listOf(comment3.id)).toList()

        assertTrue(resultTrue.contains(comment))
        assertTrue(resultTrue.contains(comment2))
        assertFalse(resultFalse.contains(comment3))
    }

    @Test
    fun delete_expected() {
        val comment2 = comment.copy(id = 1L, message = "comment2")

        val toDelete = repo.save(comment)
        val notToDelete = repo.save(comment2)

        repo.delete(toDelete)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }
}