package ru.netology.model.post.attachment.link

data class ButtonAction(
    // type
    val type: ButtonActionType = ButtonActionType.OPEN_URL,
    // url
    val url: String = "",
)
