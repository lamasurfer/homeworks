package ru.netology.model.post.attachment

enum class AttachmentType(
    val value: String,
) {
    // photo
    PHOTO("photo"),

    // audio
    AUDIO("audio"),

    // video
    VIDEO("video"),

    // link
    LINK("link"),

    // note
    NOTE("note"),
}