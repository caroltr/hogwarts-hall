package com.catenri.data.model

import com.catenri.database.model.CharacterEntity
import com.catenri.network.model.CharactersResponse

internal fun CharactersResponse.toEntity(): CharacterEntity =
    CharacterEntity(
        id = this.id,
        actor = this.actor,
        alive = this.alive,
        dateOfBirth = this.dateOfBirth,
        house = this.house,
        image = this.image,
        name = this.name,
        species = this.species
    )

internal fun CharacterEntity.toExternalCharacter() = Character(
    id = this.id,
    actor = this.actor,
    alive = this.alive,
    dateOfBirth = this.dateOfBirth,
    house = this.house,
    image = this.image,
    name = this.name,
    species = this.species
)
