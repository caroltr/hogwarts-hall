package com.catenri.hogwartshall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catenri.hogwartshall.domain.GetHarryPotterCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getHarryPotterCharactersUseCase: GetHarryPotterCharactersUseCase,
) : ViewModel() {

    val mainUiStaStateFlow: StateFlow<MainUiState> =
        getHarryPotterCharactersUseCase()
            .map(MainUiState::Success)
            .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = MainUiState.Loading,
        )
}