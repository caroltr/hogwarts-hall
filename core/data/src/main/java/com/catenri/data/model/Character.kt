package com.catenri.data.model

import kotlinx.datetime.Instant

data class Character(
    val actor: String,
    val alive: Boolean,
    val dateOfBirth: Instant?,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val species: String,
)
