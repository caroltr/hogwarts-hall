package com.catenri.network

import com.catenri.network.util.InstantParser
import kotlinx.datetime.Instant
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class InstantParserTest {

    private val sut by lazy { InstantParser() }

    @Test
    fun `when date is in correct format then parse succeeds`() {
        val date = "31-12-2024"

        val actual = sut.stringToInstant(date)
        val expected = Instant.fromEpochMilliseconds(1733875200000)

        assertEquals(expected, actual)
    }

    @Test
    fun `when date is in wrong format then parse returns null `() {
        val date = "31/12/2024"

        val actual = sut.stringToInstant(date)

        assertNull(actual)
    }

    @Test
    fun `when date is empty then parse returns null `() {
        val date = ""

        val actual = sut.stringToInstant(date)

        assertNull(actual)
    }

    @Test
    fun `when not a date is given then parse returns null `() {
        val date = "xyz"

        val actual = sut.stringToInstant(date)

        assertNull(actual)
    }

    @Test
    fun `when date is in wrong pattern then parse returns null `() {
        val date = "12/31/2024"

        val actual = sut.stringToInstant(date)

        assertNull(actual)
    }
}