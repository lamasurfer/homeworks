package ru.netology.chat.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class DirectChatTest {

    private val user1 = ChatUser(
        id = 0L,
        nickname = "user1",
    )
    private val user2 = ChatUser(
        id = 1L,
        nickname = "user2",
    )

    private val message = ChatMessage(
        id = 0L,
        senderId = user1.id,
        receiverId = user2.id,
        date = LocalDateTime.now(),
        text = "message",
    )

    @Test
    fun test_chat_defaults() {
        val id = 0L
        val chat = DirectChat(
            id = id,
            senderId = user1.id,
            receiverId = user2.id,
        )
        assertEquals(id, chat.id)
        assertEquals(user1.id, chat.senderId)
        assertEquals(user2.id, chat.receiverId)
        assertEquals(emptyList<Message>(), chat.messages)
    }
}