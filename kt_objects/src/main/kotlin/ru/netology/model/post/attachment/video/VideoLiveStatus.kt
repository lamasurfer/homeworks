package ru.netology.model.post.attachment.video

enum class VideoLiveStatus(
    val value: String,
) {
    // waiting
    WAITING("waiting"),

    // started
    STARTED("started"),

    // finished
    FINISHED("finished"),

    // failed
    FAILED("failed"),

    // upcoming
    UPCOMING("upcoming");
}