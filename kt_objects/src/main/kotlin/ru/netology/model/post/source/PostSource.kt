package ru.netology.model.post.source

data class PostSource(
    // type
    val type: PostSourceType = PostSourceType.VK,
    // platform
    val platform: String = "",
    // data
    val data: String = "",
    // url
    val url: String = "",
)