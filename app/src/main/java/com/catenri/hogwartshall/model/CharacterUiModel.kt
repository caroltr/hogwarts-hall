package com.catenri.hogwartshall.model

import com.catenri.data.model.Character
import com.catenri.hogwartshall.common.util.formatToUi

internal data class CharacterUiModel(
    val actor: String,
    val alive: Boolean,
    val dateOfBirth: String?,
    val house: CharacterHouse?,
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
    house =  CharacterHouse.entries.find { it.value.lowercase() == this.house.lowercase() },
    image = this.image,
    name = this.name,
    species = this.species
)

internal enum class CharacterHouse(val value: String) {
    GRYFFINDOR("Gryffindor"),
    SLYTHERIN("Slytherin"),
    RAVENCLAW("Ravenclaw"),
    HUFFLEPUFF("Hufflepuff"),
}