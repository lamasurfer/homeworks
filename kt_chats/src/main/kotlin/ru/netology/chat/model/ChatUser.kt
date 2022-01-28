package ru.netology.chat.model

data class ChatUser(
    override val id: Long,
    override val nickname: String,
) : User