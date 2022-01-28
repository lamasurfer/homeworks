package ru.netology.chat.model

data class DirectChat(
    override val id: Long,
    override val senderId: Long,
    override val receiverId: Long,
    override val messages: List<ChatMessage> = emptyList(),
) : Chat