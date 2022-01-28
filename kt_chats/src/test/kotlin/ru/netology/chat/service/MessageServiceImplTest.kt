package ru.netology.chat.service

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.chat.model.ChatMessage
import ru.netology.chat.model.ChatUser
import java.time.LocalDateTime

class MessageServiceImplTest {

    private val service = MessageServiceImpl()

    @Test
    fun test_createMessage_expected() {
        val first = ChatUser(0L, "user1")
        val second = ChatUser(1L, "user2")
        val date = LocalDateTime.now()
        val text = " message"

        val expected = ChatMessage(0L, first.id, second.id, date = date, text = text)

        assertEquals(expected, service.createMessage(first, second, date, text))
    }

    @Test
    fun test_editMessage_expected() {
        val date = LocalDateTime.now()
        val text = "message"
        val message = ChatMessage(0L, 0L, 1L, false, date, text)

        val newDate = LocalDateTime.now()
        val newText = "new text"
        val expected = ChatMessage(0L, 0L, 1L, false, newDate, newText)

        assertEquals(expected, service.editMessage(message, newDate, newText))
    }

    @Test
    fun test_readMessage_expected() {
        val date = LocalDateTime.now()
        val text = "message"
        val message = ChatMessage(0L, 0L, 1L, false, date, text)

        val expected = message.copy(read = true)
        assertEquals(expected, service.readMessage(message))
    }
}