package ru.netology.model.post.attachment.link

data class Button(
    // title
    val title: String = "",
    // action
    val action: ButtonAction = ButtonAction(),
)
