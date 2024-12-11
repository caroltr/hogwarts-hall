package com.catenri.hogwartshall.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catenri.hogwartshall.domain.GetSingleCharacterUseCase
import com.catenri.hogwartshall.model.CharacterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val PARAM_CHARACTER_ID = "characterId"

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase
): ViewModel() {
    
    private val characterId: String = checkNotNull(savedStateHandle[PARAM_CHARACTER_ID])
    
    private val _character = MutableStateFlow<CharacterUiModel?>(null)
    val character: StateFlow<CharacterUiModel?> = _character.asStateFlow()
    
    init {
        viewModelScope.launch {
            _character.value = getSingleCharacterUseCase(characterId)
        }
    }
}