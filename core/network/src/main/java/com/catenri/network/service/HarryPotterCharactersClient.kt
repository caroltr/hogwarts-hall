package com.catenri.network.service

import com.catenri.network.model.HarryPotterCharacterResponse
import javax.inject.Inject

class HarryPotterCharactersClient@Inject constructor(
    private val service: HarryPotterCharactersService,
) {

    suspend fun fetchCharacters(): List<HarryPotterCharacterResponse> =
        service.fetchCharacters()
}
