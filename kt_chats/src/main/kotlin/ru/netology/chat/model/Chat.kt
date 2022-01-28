package ru.netology.chat.model

sealed interface Chat : BaseEntity {
    override val id: Long
    val senderId: Long
    val receiverId: Long
    val messages: List<Message>
}