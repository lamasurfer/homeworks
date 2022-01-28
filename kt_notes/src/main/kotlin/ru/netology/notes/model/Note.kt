package ru.netology.notes.model

import java.time.LocalDateTime

data class Note(
    override val id: Long = -1L,
    val ownerId: Long,
    val title: String,
    val text: String,
    override val date: LocalDateTime,
    val comments: Long = 0L,
    val readComments: Long = 0L,
    val viewUrl: String = "note",
    val privacyView: List<String> = emptyList(),
    val privacyComment: List<String> = emptyList(),
    val canComment: Boolean = true,
    val textWiki: String = "",
    override val isRemoved: Boolean = false,
) : NoteEntity
