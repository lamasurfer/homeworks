package ru.netology.model.post.geo

data class Geo(
    // type
    val type: String = "",
    // coordinates
    val coordinates: String = "",
    // place
    val place: Place? = null,
)
