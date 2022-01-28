package ru.netology.chat.service

import ru.netology.chat.exception.ChatServiceException
import ru.netology.chat.model.ChatMessage
import ru.netology.chat.model.ChatUser
import ru.netology.chat.model.DirectChat
import ru.netology.chat.repository.MapRepoImpl
import java.util.concurrent.atomic.AtomicLong

class ChatServiceImpl(
    private val repository: MapRepoImpl<DirectChat>,
) : ChatService {

    private val counter = AtomicLong()

    private val thisUserChat: (DirectChat, ChatUser) -> Boolean = { chat, user ->
        chat.senderId == user.id || chat.receiverId == user.id
    }

    private val theseUsersChat: (DirectChat, ChatUser, ChatUser) -> Boolean = { it, first, second ->
        (it.senderId == first.id && it.receiverId == second.id) ||
                (it.senderId == second.id && it.receiverId == first.id)
    }

    override fun createChat(caller: ChatUser, receiver: ChatUser, message: ChatMessage): DirectChat {
        return repository.save(
            DirectChat(
                id = counter.getAndIncrement(),
                senderId = caller.id,
                receiverId = receiver.id,
                messages = listOf(message)
            )
        )
    }

    override fun getChat(first: ChatUser, second: ChatUser): DirectChat {
        return repository
            .findAll()
            .find { theseUsersChat(it, first, second) }
            ?: throw ChatServiceException("Chat not found!")
    }

    override fun getChatByUserAndById(user: ChatUser, chatId: Long): DirectChat {
        return repository
            .findById(chatId)
            ?.let {
                it.takeIf { thisUserChat(it, user) }
                    ?: throw ChatServiceException("Access denied!")
            } ?: throw ChatServiceException("Wrong chat id!")
    }

    override fun getChats(caller: ChatUser): Sequence<DirectChat> {
        return repository
            .findAll()
            .filter { thisUserChat(it, caller) }
    }

    override fun updateChat(chat: DirectChat, messages: List<ChatMessage>): DirectChat {
        return repository.save(chat.copy(messages = messages))
    }

    override fun deleteChat(chat: DirectChat): Boolean {
        return repository.delete(chat)
    }

    override fun hasChat(first: ChatUser, second: ChatUser): Boolean {
        return repository
            .findAll()
            .any { theseUsersChat(it, first, second) }
    }
}