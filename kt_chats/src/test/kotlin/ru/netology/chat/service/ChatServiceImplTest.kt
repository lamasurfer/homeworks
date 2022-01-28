package ru.netology.chat.service

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test
import ru.netology.chat.exception.ChatServiceException
import ru.netology.chat.model.DirectChat
import ru.netology.chat.model.ChatMessage
import ru.netology.chat.model.ChatUser
import ru.netology.chat.repository.MapRepoImpl
import java.time.LocalDateTime

class ChatServiceImplTest {

    private val repo = mockk<MapRepoImpl<DirectChat>>(relaxed = true)
    private val service = ChatServiceImpl(repo)

    @Test
    fun test_createChat_expected() {
        val first = ChatUser(0L, "user1")
        val second = ChatUser(1L, "user2")
        val message = ChatMessage(1L, first.id, second.id, false, LocalDateTime.now(), "message")

        val chat = DirectChat(0L, first.id, second.id, listOf(message))

        every { repo.save(chat) } returns chat
        assertEquals(chat, service.createChat(first, second, message))
    }

    @Test
    fun test_getChat_expected() {
        val first = ChatUser(0L, "user1")
        val second = ChatUser(1L, "user2")

        val none = sequenceOf(
            DirectChat(0L, -1L, -1L, emptyList()),
            DirectChat(1L, 1L, 2L, emptyList()),
            DirectChat(2L, 2L, 1L, emptyList()),
            DirectChat(3L, 0L, 2L, emptyList()),
            DirectChat(4L, 2L, 0L, emptyList()),
        )

        every { repo.findAll() } returns none
        try {
            service.getChat(first, second)
        } catch (e: ChatServiceException) {
            assertEquals("Chat not found!", e.message)
        }

        val directChat = DirectChat(0L, 0L, 1L, emptyList())
        val direct = sequenceOf(
            DirectChat(0L, -1L, -1L, emptyList()),
            DirectChat(1L, 1L, 2L, emptyList()),
            DirectChat(2L, 2L, 1L, emptyList()),
            DirectChat(3L, 0L, 2L, emptyList()),
            DirectChat(4L, 2L, 0L, emptyList()),
            directChat,
        )

        every { repo.findAll() } returns direct
        assertEquals(directChat, service.getChat(first, second))

        val reverseChat = DirectChat(0L, 1L, 0L, emptyList())
        val reverse = sequenceOf(
            DirectChat(0L, -1L, -1L, emptyList()),
            DirectChat(1L, 1L, 2L, emptyList()),
            DirectChat(2L, 2L, 1L, emptyList()),
            DirectChat(3L, 0L, 2L, emptyList()),
            DirectChat(4L, 2L, 0L, emptyList()),
            reverseChat,
        )

        every { repo.findAll() } returns reverse
        assertEquals(reverseChat, service.getChat(first, second))
    }

    @Test
    fun test_getChatById_noChat_exception() {
        val user = ChatUser(0L, "user1")
        val wrongId = Long.MAX_VALUE

        every { repo.findById(wrongId) } returns null
        try {
            service.getChatByUserAndById(user, wrongId)
        } catch (e: ChatServiceException) {
            assertEquals("Wrong chat id!", e.message)
        }
    }

    @Test
    fun test_getChatById_wrongChat_exception() {
        val user = ChatUser(0L, "user1")
        val wrongChat = DirectChat(0L, 1L, 2L)

        every { repo.findById(wrongChat.id) } returns wrongChat
        try {
            service.getChatByUserAndById(user, wrongChat.id)
        } catch (e: ChatServiceException) {
            assertEquals("Access denied!", e.message)
        }
    }

    @Test
    fun test_getChatById_expected() {
        val user = ChatUser(0L, "user1")

        val direct = DirectChat(0L, user.id, 2L)
        every { repo.findById(direct.id) } returns direct

        assertEquals(direct, service.getChatByUserAndById(user, direct.id))

        val reverse = DirectChat(0L, 2L, user.id)
        every { repo.findById(direct.id) } returns reverse

        assertEquals(reverse, service.getChatByUserAndById(user, reverse.id))
    }

    @Test
    fun test_getChats_expected() {
        val first = ChatUser(0L, "user1")

        val none = sequenceOf(
            DirectChat(1L, -1L, -1L, emptyList()),
            DirectChat(2L, 1L, 2L, emptyList()),
            DirectChat(3L, 2L, 1L, emptyList()),
            DirectChat(4L, 0L, 2L, emptyList()),
            DirectChat(5L, 2L, 0L, emptyList()),
        )

        val expected = listOf(
            DirectChat(4L, 0L, 2L, emptyList()),
            DirectChat(5L, 2L, 0L, emptyList()),
        )

        every { repo.findAll() } returns none
        assertEquals(expected, service.getChats(first).toList())
    }

    @Test
    fun test_updateChat_expected() {
        val chat = DirectChat(0L, 0L, 1L, listOf())
        val messages = listOf(ChatMessage(0L, 0L, 1L, date = LocalDateTime.now(), text = "message"))

        val updated = chat.copy(messages = messages)

        every { repo.save(updated) } returns updated
        assertEquals(updated, service.updateChat(chat, messages))
    }

    @Test
    fun test_deleteChat_expected() {
        val chat = DirectChat(0L, 0L, 1L, listOf())

        every { repo.delete(chat) } returns true
        assertTrue(service.deleteChat(chat))

        every { repo.delete(chat) } returns false
        assertFalse(service.deleteChat(chat))
    }

    @Test
    fun test_hasChat_expected() {
        val first = ChatUser(0L, "user1")
        val second = ChatUser(1L, "user2")

        val none = sequenceOf(
            DirectChat(0L, -1L, -1L, emptyList()),
            DirectChat(0L, 1L, 2L, emptyList()),
            DirectChat(0L, 2L, 1L, emptyList()),
            DirectChat(0L, 0L, 2L, emptyList()),
            DirectChat(0L, 2L, 0L, emptyList()),
        )

        every { repo.findAll() } returns none
        assertFalse(service.hasChat(first, second))

        val direct = sequenceOf(
            DirectChat(0L, -1L, -1L, emptyList()),
            DirectChat(0L, 1L, 2L, emptyList()),
            DirectChat(0L, 2L, 1L, emptyList()),
            DirectChat(0L, 0L, 2L, emptyList()),
            DirectChat(0L, 2L, 0L, emptyList()),
            DirectChat(0L, 0L, 1L, emptyList()),
        )

        every { repo.findAll() } returns direct
        assertTrue(service.hasChat(first, second))

        val reverse = sequenceOf(
            DirectChat(0L, -1L, -1L, emptyList()),
            DirectChat(0L, 1L, 2L, emptyList()),
            DirectChat(0L, 2L, 1L, emptyList()),
            DirectChat(0L, 0L, 2L, emptyList()),
            DirectChat(0L, 2L, 0L, emptyList()),
            DirectChat(0L, 1L, 0L, emptyList()),
        )

        every { repo.findAll() } returns reverse
        assertTrue(service.hasChat(first, second))
    }
}