package ru.netology.model.post.source

enum class PostSourceType(val value: String) {
    VK("vk"),
    WIDGET("widget"),
    API("api"),
    RSS("rss"),
    SMS("sms"),
}