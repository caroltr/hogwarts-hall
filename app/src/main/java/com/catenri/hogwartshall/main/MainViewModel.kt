package com.catenri.hogwartshall.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catenri.hogwartshall.domain.FilterCharactersUseCase
import com.catenri.hogwartshall.domain.GetHarryPotterCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getHarryPotterCharactersUseCase: GetHarryPotterCharactersUseCase,
    filterCharactersUseCase: FilterCharactersUseCase,
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    // TODO handle configuration change here, to deal with search
    val mainUiStaStateFlow: StateFlow<MainUiState> =
        combine(
            getHarryPotterCharactersUseCase(),
            searchQuery
        ) { characters, query ->
            filterCharactersUseCase(query, characters)
        }
            .map(MainUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = MainUiState.Loading,
            )

    fun onSearchQueryChange(query: String) {
        searchQuery.value = query
    }
}