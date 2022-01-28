package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class TransferKtTest {

    @Test
    fun test_main_noExceptionsThrown() {
        try {
            main()
        } catch (e: Exception) {
            fail("No exceptions expected!")
        }
    }

    @Test
    fun test_getFee_withDefaults_expectedBehaviour() {
        val currentAmount = 5000_00L
        val expected = 0L
        assertEquals(expected, getFee(currentAmount = currentAmount))
    }
}