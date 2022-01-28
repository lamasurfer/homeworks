package ru.netology.chat.service

import ru.netology.chat.model.ChatMessage
import ru.netology.chat.model.Message
import ru.netology.chat.model.User
import java.time.LocalDateTime

interface MessageService {

    fun createMessage(
        caller: User,
        receiver: User,
        date: LocalDateTime,
        text: String,
    ): ChatMessage

    fun editMessage(
        message: ChatMessage,
        date: LocalDateTime,
        text: String,
    ): Message

    fun readMessage(message: ChatMessage): ChatMessage
}