package com.catenri.hogwartshall.common.util

import kotlinx.datetime.Instant
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InstantExtensionsTest {

    @Test
    fun `when provided valid instant then format succeeds`() {
        val instant = Instant.fromEpochMilliseconds(1733875200000) // 11 Dec 2024 00:00:00

        val actual = instant.formatToUi()
        val expected = "11 Dec 2024"

        assertEquals(expected, actual)
    }
}