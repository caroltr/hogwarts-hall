package com.catenri.hogwartshall.domain

import com.catenri.data.repository.CharactersRepository
import com.catenri.hogwartshall.model.CharacterUiModel
import com.catenri.hogwartshall.model.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetCharactersUseCase @Inject constructor(
    private val remoteRepository: CharactersRepository
) {

    operator fun invoke(): Flow<List<CharacterUiModel>> =
        remoteRepository.getCharacters().map { characters ->
            characters.map { it.toUiModel() }
        }.catch { emptyList<CharacterUiModel>() }
}
