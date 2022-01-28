package ru.netology.model.comment

import ru.netology.model.post.donut.Placeholder

data class CommentDonut(
    // is_don
    val isDon: Boolean = false,
    // placeholder
    val placeholder: Placeholder = Placeholder(),
)
