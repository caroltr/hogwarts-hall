package com.catenri.hogwartshall.domain

import com.catenri.hogwartshall.model.CharacterUiModel
import javax.inject.Inject

internal class FilterCharactersUseCase @Inject constructor() {

    operator fun invoke(
        searchQuery: String,
        characters: List<CharacterUiModel>
    ): List<CharacterUiModel> =
        characters.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
                    it.actor.contains(searchQuery, ignoreCase = true)
        }
}
