package ru.netology.model.post.attachment.video

enum class VideoType(
    val value: String,
) {
    // video
    VIDEO("video"),

    // music_video
    MUSIC_VIDEO("music_video"),

    // movie
    MOVIE("movie");
}