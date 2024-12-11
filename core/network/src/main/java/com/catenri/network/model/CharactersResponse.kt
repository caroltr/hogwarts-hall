package com.catenri.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.datetime.Instant

data class CharactersResponse(
    @SerializedName("actor") val actor: String,
    @SerializedName("alive") val alive: Boolean,
    @SerializedName("alternate_actors") val alternateActors: List<String>,
    @SerializedName("alternate_names") val alternateNames: List<String>,
    @SerializedName("ancestry") val ancestry: String,
    @SerializedName("dateOfBirth") val dateOfBirth: Instant, // pattern: 06-12-1928
    @SerializedName("eyeColour") val eyeColour: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("hairColour") val hairColour: String,
    @SerializedName("hogwartsStaff") val hogwartsStaff: Boolean,
    @SerializedName("hogwartsStudent") val hogwartsStudent: Boolean,
    @SerializedName("house") val house: String,
    @SerializedName("id") val id: String, // 36bfefd0-e0bb-4d11-be98-d1ef6117a77a
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("patronus") val patronus: String,
    @SerializedName("species") val species: String,
    @SerializedName("wand") val wand: Wand,
    @SerializedName("wizard") val wizard: Boolean,
    @SerializedName("yearOfBirth") val yearOfBirth: Int
)

data class Wand(
    @SerializedName("core") val core: String,
    @SerializedName("length") val length: Double,
    @SerializedName("wood") val wood: String
)