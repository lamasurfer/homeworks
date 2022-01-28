package ru.netology.chat.exception

class ChatServiceException(override val message: String) : RuntimeException(message)