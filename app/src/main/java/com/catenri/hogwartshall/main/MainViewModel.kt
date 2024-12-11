package com.catenri.hogwartshall.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catenri.hogwartshall.domain.FilterCharactersUseCase
import com.catenri.hogwartshall.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getCharactersUseCase: GetCharactersUseCase,
    filterCharactersUseCase: FilterCharactersUseCase,
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    // TODO handle configuration change here, to deal with search
    val mainUiStaStateFlow: StateFlow<MainUiState> =
        combine(
            getCharactersUseCase(),
            searchQuery
        ) { characters, query ->
            filterCharactersUseCase(query, characters)
        }.catch { MainUiState.LoadFailed }
            .map { characters ->
                if (characters.isEmpty()) {
                    MainUiState.LoadFailed
                } else {
                    MainUiState.Success(characters)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = MainUiState.Loading,
            )

    fun onSearchQueryChange(query: String) {
        searchQuery.value = query
    }
}