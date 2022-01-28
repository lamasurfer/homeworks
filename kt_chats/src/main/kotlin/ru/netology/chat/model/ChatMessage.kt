package ru.netology.chat.model

import java.time.LocalDateTime

data class ChatMessage(
    override val id: Long,
    override val senderId: Long,
    override val receiverId: Long,
    override val read: Boolean = false,
    override val date: LocalDateTime,
    override val text: String,
) : Message

