package ru.netology.notes.model

import java.time.LocalDateTime

sealed interface NoteEntity {
    val id: Long
    val date: LocalDateTime
    val isRemoved: Boolean
}