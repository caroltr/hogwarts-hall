package com.catenri.hogwartshall.common.ui.util

import kotlinx.datetime.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

private const val PATTERN = "dd MM yyyy"
internal class InstantFormatter @Inject constructor() {

    operator fun invoke(instant: Instant): String {
        val iso8601Date = instant.toString()

        val isoFormatter = DateTimeFormatter.ISO_DATE_TIME
        val dateTime = LocalDateTime.parse(iso8601Date, isoFormatter)
        val customFormatter = DateTimeFormatter.ofPattern(PATTERN)

        return dateTime.format(customFormatter)
    }

}