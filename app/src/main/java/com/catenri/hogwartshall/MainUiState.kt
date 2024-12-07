package com.catenri.hogwartshall

import com.catenri.data.model.Character

sealed interface MainUiState {

    data object Loading : MainUiState

    data object LoadFailed : MainUiState

    data class Success(
        val characters: List<Character>
    ) : MainUiState
}