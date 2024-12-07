package com.catenri.data.model

import com.catenri.network.model.HarryPotterCharacterResponse

data class Character(
    val actor: String,
    val alive: Boolean,
    val dateOfBirth: String?,
    val house: String,
    val id: String, // 36bfefd0-e0bb-4d11-be98-d1ef6117a77a
    val image: String,
    val name: String,
    val species: String,
    val yearOfBirth: Int // pattern: 06-12-1928
)

internal fun HarryPotterCharacterResponse.toCharacter(): Character = Character(
    actor = this.actor,
    alive = this.alive,
    dateOfBirth = this.dateOfBirth,
    house = this.house,
    id = this.id,
    image = this.image,
    name = this.name,
    species = this.species,
    yearOfBirth = this.yearOfBirth,
)
