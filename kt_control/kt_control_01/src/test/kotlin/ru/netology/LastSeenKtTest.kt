package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LastSeenKtTest {

    @Test
    fun test_agoToText_expectedBehaviour() {
        assertEquals("был(а) в сети только что", agoToText(minute - 1))
        assertEquals("был(а) в сети 1 минуту назад", agoToText(minute))
        assertEquals("был(а) в сети 2 минуты назад", agoToText(minute * 2))
        assertEquals("был(а) в сети 5 минут назад", agoToText(minute * 5))
        assertEquals("был(а) в сети 11 минут назад", agoToText(minute * 11))
        assertEquals("был(а) в сети 21 минуту назад", agoToText(minute * 21))
        assertEquals("был(а) в сети 59 минут назад", agoToText(hour - 1))
        assertEquals("был(а) 1 час назад", agoToText(hour))
        assertEquals("был(а) 2 часа назад", agoToText(hour * 2))
        assertEquals("был(а) 5 часов назад", agoToText(hour * 5))
        assertEquals("был(а) 11 часов назад", agoToText(hour * 11))
        assertEquals("был(а) 21 час назад", agoToText(hour * 21))
        assertEquals("был(а) 23 часа назад", agoToText(day - 1))
        assertEquals("был(а) сегодня", agoToText(day))
        assertEquals("был(а) сегодня", agoToText(day + 1))
        assertEquals("был(а) вчера", agoToText(day * 2))
        assertEquals("был(а) давно", agoToText(day * 3))
    }

    @Test
    fun test_getTimeAsString_expectedBehaviour() {
        assertEquals("1 минуту", getTimeAsString(minute, minute / minute))
        assertEquals("2 минуты", getTimeAsString(minute * 2, minute * 2 / minute))
        assertEquals("5 минут", getTimeAsString(minute * 5, minute * 5 / minute))
        assertEquals("11 минут", getTimeAsString(minute * 11, minute * 11 / minute))
        assertEquals("21 минуту", getTimeAsString(minute * 21, minute * 21 / minute))
        assertEquals("59 минут", getTimeAsString(hour - 1, (hour - 1) / minute))
        assertEquals("1 час", getTimeAsString(hour, hour / hour))
        assertEquals("2 часа", getTimeAsString(hour * 2, hour * 2 / hour))
        assertEquals("5 часов", getTimeAsString(hour * 5, hour * 5 / hour))
        assertEquals("11 часов", getTimeAsString(hour * 11, hour * 11 / hour))
        assertEquals("21 час", getTimeAsString(hour * 21, hour * 21 / hour))
        assertEquals("23 часа", getTimeAsString(day - 1, (day - 1) / hour))
    }

    @Test
    fun test_getPluralForm_expectedBehaviour() {
        val forms0 = arrayOf(1, 21, 31, 41, 51, 61)
        forms0.forEach { assertEquals(0, getPluralForm(it)) }

        val forms1 = arrayOf(2, 3, 4, 22, 23, 24)
        forms1.forEach { assertEquals(1, getPluralForm(it)) }

        val forms2 = arrayOf(0, 5, 6, 7, 8, 9, 10, 11)
        forms2.forEach { assertEquals(2, getPluralForm(it)) }
    }
}