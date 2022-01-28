package ru.netology.model.comment

import ru.netology.model.post.attachment.Attachment

data class Comment(
    // val
    val id: Long = 0L,
    // post_id
    val postId: Long = 0L,
    // from_id
    val fromId: Long = 0L,
    // date
    val date: Long = 0L,
    // text
    val text: String = "",
    // donut
    val donut: CommentDonut = CommentDonut(),
    // reply_to_user
    val replyToUser: Long = 0L,
    // reply_to_comment
    val replyToComment: Long = 0L,
    // attachments
    val attachments: List<Attachment> = arrayListOf(),
    // parents_stack
    val parentsStack: List<Long> = arrayListOf(),
    // thread
    val thread: CommentThread = CommentThread(),
)
