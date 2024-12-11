package com.catenri.network.service

import com.catenri.network.model.CharactersResponse
import javax.inject.Inject

class CharactersClient@Inject constructor(
    private val service: CharactersService,
) {

    suspend fun fetchCharacters(): List<CharactersResponse> =
        service.fetchCharacters()
}
