package ru.netology.exception

class CommentNotFoundException(message: String = "Comment not found!") : RuntimeException(message)