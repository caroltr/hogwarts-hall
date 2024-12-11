package com.catenri.hogwartshall.model

import com.catenri.data.model.Character

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
    dateOfBirth = this.dateOfBirth,
    house = this.house,
    image = this.image,
    name = this.name,
    species = this.species
)