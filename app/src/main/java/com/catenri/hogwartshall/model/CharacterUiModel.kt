package com.catenri.hogwartshall.model

import com.catenri.data.model.Character
import com.catenri.hogwartshall.common.util.formatToUi

data class CharacterUiModel(
    val actor: String,
    val alive: Boolean,
    val dateOfBirth: String?,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val species: String,
)

internal fun Character.toUiModel() = CharacterUiModel(
    id = this.id,
    actor = this.actor,
    alive = this.alive,
    dateOfBirth = this.dateOfBirth?.formatToUi(),
    house = this.house,
    image = this.image,
    name = this.name,
    species = this.species
)