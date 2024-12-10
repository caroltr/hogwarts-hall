package com.catenri.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "character",
)
data class CharacterEntity(
    @PrimaryKey
    val id: String,
    val actor: String,
    val alive: Boolean,
    val dateOfBirth: String?,
    val house: String,
    val image: String,
    val name: String,
    val species: String,
)
