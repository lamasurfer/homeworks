package ru.netology.chat.service

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test
import ru.netology.chat.exception.ChatServiceException
import ru.netology.chat.model.ChatUser
import ru.netology.chat.repository.MapRepoImpl

class UserServiceImplTest {

    private val repository = mockk<MapRepoImpl<ChatUser>>(relaxed = true)
    private val service = UserServiceImpl(repository)

    private val id = 0L
    private val nickname = "nickname"
    private val user = ChatUser(
        id = id,
        nickname = nickname,
    )

    @Test
    fun test_addUser_expected() {
        every { repository.save(any()) } returns user
        assertEquals(user, service.addUser(nickname))
    }

    @Test
    fun test_getUser_expected() {
        every { repository.findById(user.id) } returns user
        assertEquals(user, service.getUser(user.id))
    }

    @Test
    fun test_getUser_expected_exception() {
        val wrongId = Long.MAX_VALUE

        every { repository.findById(wrongId) } returns null
        try {
            service.getUser(wrongId)
        } catch (e: ChatServiceException) {
            assertEquals("User not found!", e.message)
        }
    }

    @Test
    fun test_updateUser_expected() {
        every { repository.save(user) } returns user
        assertEquals(user, service.updateUser(user))
    }

    @Test
    fun test_deleteUser_expected() {
        val wrongId = Long.MAX_VALUE
        val wrongUser = user.copy(id = wrongId)

        every { repository.delete(user) } returns true
        assertTrue(service.deleteUser(user))

        every { repository.delete(wrongUser) } returns false
        assertFalse(service.deleteUser(wrongUser))
    }
}