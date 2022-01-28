package ru.netology.chat.service

import ru.netology.chat.model.ChatMessage
import ru.netology.chat.model.User
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

class MessageServiceImpl : MessageService {

    private val counter = AtomicLong()

    override fun createMessage(
        caller: User,
        receiver: User,
        date: LocalDateTime,
        text: String,
    ): ChatMessage {
        return ChatMessage(
            id = counter.getAndIncrement(),
            senderId = caller.id,
            receiverId = receiver.id,
            date = date,
            text = text,
        )
    }

    override fun editMessage(
        message: ChatMessage,
        date: LocalDateTime,
        text: String,
    ): ChatMessage {
        return message.copy(date = date, text = text)
    }

    override fun readMessage(message: ChatMessage): ChatMessage {
        return message.copy(read = true)
    }
}