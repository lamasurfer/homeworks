package ru.netology.model.post.donut

data class Donut(
    // is_donut
    val isDonut: Boolean = false,
    // paid_duration
    val paidDuration: Long = 0L,
    // placeholder
    val placeholder: Placeholder = Placeholder(),
    // can_publish_free_copy
    val canPublishFreeCopy: Boolean = false,
    // edit_mode
    val editMode: EditMode = EditMode.ALL,
)