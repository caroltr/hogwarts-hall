package com.catenri.hogwartshall.domain

import com.catenri.data.repository.CharactersRepository
import com.catenri.hogwartshall.model.CharacterUiModel
import com.catenri.hogwartshall.model.toUiModel
import javax.inject.Inject

internal class GetSingleCharacterUseCase @Inject constructor(
    private val repository: CharactersRepository
) {

    suspend operator fun invoke(id: String): CharacterUiModel =
        repository.getCharacter(id).toUiModel()
}
