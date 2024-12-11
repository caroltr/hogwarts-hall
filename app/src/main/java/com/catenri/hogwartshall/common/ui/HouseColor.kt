package com.catenri.hogwartshall.common.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.catenri.hogwartshall.ui.theme.HogwartsColors


@Composable
internal fun houseColor(house: String): Color = when (house) {
    "gryffindor" -> HogwartsColors.gryffindor
    "slytherin" -> HogwartsColors.slytherin
    "ravenclaw" -> HogwartsColors.ravenclaw
    "hufflepuff" -> HogwartsColors.hufflepuff
    else -> MaterialTheme.colorScheme.surfaceVariant
}