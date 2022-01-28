package ru.netology.chat.repository

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.chat.model.ChatUser

class MapRepoImplTest {

    private val repo = MapRepoImpl<ChatUser>()

    private val id = 0L
    private val nickname = "user1"

    private val user = ChatUser(
        id = id,
        nickname = nickname,
    )

    @Before
    fun init() {
        repo.deleteAll()
    }

    @Test
    fun test_save_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")


        assertEquals(user, repo.save(user))
        assertEquals(user2, repo.save(user2))
    }

    @Test
    fun test_findAll_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")
        val user3 = user.copy(id = 2L, nickname = "user3")

        repo.save(user)
        repo.save(user2)
        repo.save(user3)

        val list = listOf(user, user2, user3)

        assertEquals(list, repo.findAll().toList())
    }

    @Test
    fun test_count_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")
        val user3 = user.copy(id = 2L, nickname = "user3")

        repo.save(user)
        repo.save(user2)
        repo.save(user3)

        val expected = 3L
        assertEquals(expected, repo.count())
    }

    @Test
    fun test_findById_expected() {

        val expected = repo.save(user)

        assertEquals(expected, repo.findById(expected.id))

        val notFound = repo.findById(Long.MAX_VALUE)
        assertNull(notFound)
    }

    @Test
    fun test_existsById_expected() {

        val saved = repo.save(user)
        val notSaved = user.copy(id = Long.MAX_VALUE)

        assertTrue(repo.existsById(saved.id))
        assertFalse(repo.existsById(notSaved.id))
    }

    @Test
    fun test_deleteById_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")

        val toDelete = repo.save(user)
        val notToDelete = repo.save(user2)

        repo.deleteById(toDelete.id)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }

    @Test
    fun test_deleteByIds_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")

        val toDelete = repo.save(user)
        val notToDelete = repo.save(user2)

        repo.deleteById(toDelete.id)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }

    @Test
    fun findAllByIds_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")
        val user3 = user.copy(id = 2L, nickname = "user3")

        repo.save(user)
        repo.save(user2)

        val resultTrue = repo.findAllByIds(listOf(user.id, user2.id)).toList()
        val resultFalse = repo.findAllByIds(listOf(user3.id)).toList()

        assertTrue(resultTrue.contains(user))
        assertTrue(resultTrue.contains(user2))
        assertFalse(resultFalse.contains(user3))
    }

    @Test
    fun delete_expected() {
        val user2 = user.copy(id = 1L, nickname = "user2")

        val toDelete = repo.save(user)
        val notToDelete = repo.save(user2)

        repo.delete(toDelete)

        assertFalse(repo.existsById(toDelete.id))
        assertTrue(repo.existsById(notToDelete.id))
    }
}