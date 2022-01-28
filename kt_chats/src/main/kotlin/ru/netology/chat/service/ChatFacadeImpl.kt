package ru.netology.chat.service

import ru.netology.chat.model.Chat
import ru.netology.chat.model.Message
import java.time.LocalDateTime

class ChatFacadeImpl(
    private val userService: UserService,
    private val chatService: ChatService,
    private val messageService: MessageService,
) : ChatFacade {

    override fun getUnreadChatsCount(callerId: Long): Int {
        return userService
            .getUser(callerId)
            .let {
                chatService.getChats(it)
                    .filter { chat ->
                        chat.messages
                            .any { message -> message.senderId == it.id && !message.read }
                    }
                    .count()
            }
    }

    fun getChats(callerId: Long): String {
        return getChatsList(callerId)
            .let {
                if (it.isEmpty()) "нет сообщений" else it.joinToString()
            }
    }

    override fun getChatsList(callerId: Long): List<Chat> {
        return userService.getUser(callerId)
            .let { user ->
                chatService.getChats(user)
                    .filter { it.messages.isNotEmpty() }
                    .toList()
            }
    }

    override fun getMessages(
        callerId: Long,
        chatId: Long,
        lastMessageId: Long,
        count: Int,
    ): List<Message> {
        userService.getUser(callerId)
            .let {
                chatService.getChatByUserAndById(it, chatId)
            }.let { chat ->
                val target = chat.messages
                    .indexOfFirst { message -> message.id == lastMessageId }
                    .takeIf { it > 0 } ?: return emptyList()
                val messages = chat.messages
                    .filterIndexed { index, _ -> index >= target }
                    .map { messageService.readMessage(it) }
                chatService.updateChat(chat, messages)
                return messages
            }
    }

    override fun createMessage(
        callerId: Long,
        receiverId: Long,
        date: LocalDateTime,
        text: String,
    ): Message {
        val first = userService.getUser(callerId)
        val second = userService.getUser(receiverId)
        val message = messageService.createMessage(first, second, date, text)
        runCatching {
            chatService.getChat(first, second)
        }.onSuccess {
            chatService.updateChat(it, listOf(message))
        }.onFailure {
            chatService.createChat(first, second, message)
        }
        return message
    }

    override fun deleteMessage(callerId: Long, id: Long): Boolean {
        userService.getUser(callerId)
            .let { chatService.getChats(it) }
            .find { it.messages.any { message -> message.id == id } }
            ?.let { chat ->
                chat.takeIf { it.messages.last().id == id }
                    ?.let { chatService.deleteChat(it) }
                    ?: chatService.updateChat(chat, chat.messages.filterNot { message -> message.id == id })
                return true
            } ?: return false
    }

    override fun deleteChat(callerId: Long, chatId: Long): Boolean {
        return userService.getUser(callerId)
            .let { chatService.getChatByUserAndById(it, chatId) }
            .let { chatService.deleteChat(it) }
    }

    fun editMessage(
        callerId: Long,
        chatId: Long,
        messageId: Long,
        date: LocalDateTime,
        text: String,
    ): Boolean {
        userService.getUser(callerId).let {
            chatService.getChatByUserAndById(it, chatId)
        }.let {
            it.messages.find { message -> message.id == messageId }
        }?.let {
            messageService.editMessage(it, date, text)
            return true
        } ?: return false
    }
}
