package com.catenri.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

private const val TABLE_NAME = "character"

@Entity(tableName = TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey
    val id: String,
    val actor: String,
    val alive: Boolean,
    val dateOfBirth: Instant?,
    val house: String,
    val image: String,
    val name: String,
    val species: String,
)
