package ru.netology.chat.service

import ru.netology.chat.model.Chat
import ru.netology.chat.model.Message
import java.time.LocalDateTime

interface ChatFacade {

    fun getUnreadChatsCount(callerId: Long): Int

    fun getChatsList(callerId: Long): List<Chat>

    fun getMessages(
        callerId: Long,
        chatId: Long,
        lastMessageId: Long,
        count: Int,
    ): List<Message>

    fun createMessage(
        callerId: Long,
        receiverId: Long,
        date: LocalDateTime,
        text: String,
    ): Message

    fun deleteMessage(
        callerId: Long,
        id: Long,
    ): Boolean

    fun deleteChat(
        callerId: Long,
        chatId: Long,
    ): Boolean

}