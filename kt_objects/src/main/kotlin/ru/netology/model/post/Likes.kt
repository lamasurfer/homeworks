package ru.netology.model.post

data class Likes(
    // count
    val count: Long = 0L,
    // user_likes
    val userLikes: Boolean = false,
    // can_like
    val canLike: Boolean = false,
    // can_publish
    val canPublish: Boolean = false,
)



