package com.catenri.hogwartshall.domain

import com.catenri.data.repository.CharactersRepositoryImpl
import javax.inject.Inject

class GetSingleCharacterUseCase @Inject constructor(
    private val repository: CharactersRepositoryImpl
) {

    suspend operator fun invoke(id: String) =
        repository.getCharacter(id)
}
