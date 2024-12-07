package com.catenri.network.service

import com.catenri.network.model.HarryPotterCharacterResponse
import retrofit2.Response
import javax.inject.Inject

class HarryPotterCharactersClient@Inject constructor(
    private val service: HarryPotterCharactersService,
) {

    suspend fun fetchCharacters(): Response<List<HarryPotterCharacterResponse>> =
        service.fetchCharacters()
}
