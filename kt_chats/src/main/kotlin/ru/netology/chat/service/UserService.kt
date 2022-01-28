package ru.netology.chat.service

import ru.netology.chat.model.ChatUser

interface UserService {

    fun addUser(nickname: String): ChatUser

    fun getUser(userId: Long): ChatUser

    fun updateUser(user: ChatUser): ChatUser

    fun deleteUser(user: ChatUser): Boolean
}

