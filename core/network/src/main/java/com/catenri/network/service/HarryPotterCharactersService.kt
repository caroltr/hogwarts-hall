package com.catenri.network.service

import com.catenri.network.model.HarryPotterCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface HarryPotterCharactersService {

    @GET("characters")
    suspend fun fetchCharacters(): Response<List<HarryPotterCharacterResponse>>
}