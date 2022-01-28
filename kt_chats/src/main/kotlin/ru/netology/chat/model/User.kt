package ru.netology.chat.model

interface User : BaseEntity {
    override val id: Long
    val nickname: String
}