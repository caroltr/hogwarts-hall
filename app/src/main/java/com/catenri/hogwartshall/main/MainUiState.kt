package com.catenri.hogwartshall.main

import com.catenri.hogwartshall.model.CharacterUiModel

sealed interface MainUiState {

    data object Loading : MainUiState

    data object LoadFailed : MainUiState

    data class Success(
        val characters: List<CharacterUiModel>
    ) : MainUiState
}