package com.catenri.hogwartshall.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.catenri.hogwartshall.model.CharacterHouse
import com.catenri.hogwartshall.ui.theme.HogwartsColors


@Composable
internal fun houseColor(house: CharacterHouse?): Color = when (house) {
    CharacterHouse.GRYFFINDOR -> HogwartsColors.gryffindor
    CharacterHouse.SLYTHERIN -> HogwartsColors.slytherin
    CharacterHouse.RAVENCLAW -> HogwartsColors.ravenclaw
    CharacterHouse.HUFFLEPUFF -> HogwartsColors.hufflepuff
    null -> Color.Transparent
}