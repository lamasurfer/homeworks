package ru.netology.model.post

enum class PostType(
    val value: String,
) {
    // post
    POST("post"),

    // copy
    COPY("copy"),

    // reply
    REPLY("reply"),

    // postpone
    POSTPONE("postpone"),

    // suggest
    SUGGEST("suggest"),
}