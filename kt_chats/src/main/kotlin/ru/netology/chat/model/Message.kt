package ru.netology.chat.model

import java.time.LocalDateTime

sealed interface Message : BaseEntity {
    override val id: Long
    val senderId: Long
    val receiverId: Long
    val read: Boolean
    val date: LocalDateTime
    val text: String
}