package com.catenri.hogwartshall.common.util

import kotlinx.datetime.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val PATTERN = "dd MMM yyyy"

internal fun Instant.formatToUi(): String {
    val iso8601Date = this.toString()

    val isoFormatter = DateTimeFormatter.ISO_DATE_TIME
    val dateTime = LocalDateTime.parse(iso8601Date, isoFormatter)
    val customFormatter = DateTimeFormatter.ofPattern(PATTERN)

    return dateTime.format(customFormatter)
}
