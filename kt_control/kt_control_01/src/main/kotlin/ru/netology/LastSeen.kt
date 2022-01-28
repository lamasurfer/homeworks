package ru.netology

const val minute = 60
const val hour = minute * 60
const val day = hour * 24

fun main() {
    val times = listOf(
        minute - 1, minute, minute * 2, minute * 5, minute * 11, minute * 21,
        hour - 1, hour, hour * 2, hour * 5, hour * 11, hour * 21,
        day - 1, day, day * 2, day * 3, day * 5,
    )
    for (i in times) {
        println(agoToText(i))
    }
}

fun agoToText(time: Int): String {
    val lastSeen = when {
        time < minute -> "только что"
        time < hour -> "${getTimeAsString(time, time / minute)} назад"
        time < day -> "${getTimeAsString(time, time / hour)} назад"
        time < 2 * day -> "сегодня"
        time < 3 * day -> "вчера"
        else -> "давно"
    }
    val online = if (time < hour) " в сети " else " "
    return "был(а)$online$lastSeen"
}

fun getTimeAsString(time: Int, quantity: Int): String {
    val minutes = mapOf(0 to "минуту", 1 to "минуты", 2 to "минут")
    val hours = mapOf(0 to "час", 1 to "часа", 2 to "часов")
    val pluralForm = getPluralForm(quantity)
    val string = if (time < hour) minutes[pluralForm] else hours[pluralForm]
    return "$quantity $string"
}

fun getPluralForm(quantity: Int): Int {
    return when {
        quantity % 10 == 1 && quantity % 100 != 11 -> 0
        quantity % 10 in 2..4 && (quantity % 100 < 10 || quantity % 100 >= 20) -> 1
        else -> 2
    }
}

