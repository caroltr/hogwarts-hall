package com.catenri.network.util

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import javax.inject.Inject

class InstantParser @Inject constructor() {

    fun stringToInstant(dateString: String): Instant? =
        try {
            val parts = dateString.split("-")
            val day = parts[0].toInt()
            val month = parts[1].toInt()
            val year = parts[2].toInt()

            val localDate = LocalDate(year, month, day)

            localDate.atStartOfDayIn(TimeZone.currentSystemDefault())
        } catch (e: NumberFormatException) {
            null
        }
}