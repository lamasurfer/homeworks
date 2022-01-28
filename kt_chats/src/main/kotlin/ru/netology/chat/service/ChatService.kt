package ru.netology.chat.service

import ru.netology.chat.model.ChatMessage
import ru.netology.chat.model.ChatUser
import ru.netology.chat.model.DirectChat

interface ChatService {

    fun createChat(
        caller: ChatUser,
        receiver: ChatUser,
        message: ChatMessage,
    ): DirectChat

    fun getChat(first: ChatUser, second: ChatUser): DirectChat

    fun getChatByUserAndById(user: ChatUser, chatId: Long): DirectChat

    fun getChats(caller: ChatUser): Sequence<DirectChat>

    fun updateChat(
        chat: DirectChat,
        messages: List<ChatMessage>,
    ): DirectChat

    fun deleteChat(chat: DirectChat): Boolean

    fun hasChat(first: ChatUser, second: ChatUser): Boolean
}