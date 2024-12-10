package com.catenri.data.model

import com.catenri.database.model.CharacterEntity
import com.catenri.network.model.HarryPotterCharacterResponse

internal fun HarryPotterCharacterResponse.toCharacter(): Character = Character(
    actor = this.actor,
    alive = this.alive,
    dateOfBirth = this.dateOfBirth,
    house = this.house,
    id = this.id,
    image = this.image,
    name = this.name,
    species = this.species
)

internal fun Character.toEntity(): CharacterEntity = CharacterEntity(
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
