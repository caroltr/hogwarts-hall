package com.catenri.hogwartshall.domain

import com.catenri.data.repository.RemoteRepository
import javax.inject.Inject

class GetHarryPotterCharactersUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {

    suspend fun getCharacters() {
        remoteRepository.fetchCharacters()
    }
}