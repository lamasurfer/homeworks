package ru.netology.chat.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class ChatMessageTest {

    @Test
    fun test_message_defaults() {
        val id = 0L
        val senderId = 0L
        val receiverId = 1L
        val edited = LocalDateTime.now()
        val text = "message"
        val message = ChatMessage(
            id = id,
            senderId = senderId,
            receiverId = receiverId,
            date = edited,
            text = text,
        )
        assertEquals(id, message.id)
        assertEquals(senderId, message.senderId)
        assertEquals(receiverId, message.receiverId)
        assertEquals(edited, message.date)
        assertEquals(false, message.read)
        assertEquals(text, message.text)
    }
}