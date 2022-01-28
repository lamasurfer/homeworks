package ru.netology.model.post

data class Comments(
    // count
    val count: Long = 0L,
    // can_post
    val canPost: Boolean = false,
    // group_can_post
    val groupsCanPost: Boolean = false,
    // can_close
    val canClose: Boolean = false,
    // can_open
    val canOpen: Boolean = false,
)