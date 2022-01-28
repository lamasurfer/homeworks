package ru.netology.notes.model

import java.time.LocalDateTime

data class Comment(
    override val id: Long = -1L,
    val uid: Long,
    val nid: Long,
    val oid: Long,
    override val date: LocalDateTime,
    val message: String,
    val replyTo: Long,
    val guid: String,
    override val isRemoved: Boolean = false,
) : NoteEntity