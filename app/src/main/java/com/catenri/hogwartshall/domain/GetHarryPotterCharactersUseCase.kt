package com.catenri.hogwartshall.domain

import com.catenri.data.model.Character
import com.catenri.data.repository.CharactersRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHarryPotterCharactersUseCase @Inject constructor(
    private val remoteRepository: CharactersRepositoryImpl
) {

    // TODO map to a different model here
    operator fun invoke(): Flow<List<Character>> =
        remoteRepository.getCharacters()
}
