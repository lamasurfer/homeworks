package ru.netology.model.comment

data class CommentThread(
    // count
    val count: Long = 0L,
    // items
    val items: List<Comment> = arrayListOf(),
    // can_post
    val canPost: Boolean = false,
    // show_reply_button
    val showReplyButton: Boolean = false,
    // groups_can_post
    val groupsCanPost: Boolean = false,
)
