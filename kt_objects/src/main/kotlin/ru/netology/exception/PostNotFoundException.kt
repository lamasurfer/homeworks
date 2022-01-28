package ru.netology.exception

class PostNotFoundException(message: String = "Post not found!") : RuntimeException(message)