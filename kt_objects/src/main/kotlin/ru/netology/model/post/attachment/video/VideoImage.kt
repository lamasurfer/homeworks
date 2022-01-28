package ru.netology.model.post.attachment.video

data class VideoImage(
    // height
    val height: Int = 0,
    // url
    val url: String = "",
    // width
    val width: Int = 0,
    // with_padding
    val withPadding: Boolean = false,
)
