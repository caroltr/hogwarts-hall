package com.catenri.network.service

import com.catenri.network.model.CharactersResponse
import retrofit2.http.GET

private const val GET_CHARACTERS_ENDPOINT = "characters"

interface CharactersService {

    @GET(GET_CHARACTERS_ENDPOINT)
    suspend fun fetchCharacters(): List<CharactersResponse>
}
