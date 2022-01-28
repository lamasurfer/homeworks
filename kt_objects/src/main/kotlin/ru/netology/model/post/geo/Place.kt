package ru.netology.model.post.geo

data class Place(
    // id
    val id: Long = 0L,
    // title
    val title: String = "",
    // latitude
    val latitude: Long = 0L,
    // longitude
    val longitude: Long = 0L,
    // created
    val created: Long = 0L,
    // icon
    val icon: String = "",
    // checkins
    val checkins: Long = 0L,
    // updated
    val updated: Long = 0L,
    // type
    val type: Long = 0L,
    // country
    val country: Long = 0L,
    // city
    val city: Long = 0L,
    // address
    val address: String = "",
)
