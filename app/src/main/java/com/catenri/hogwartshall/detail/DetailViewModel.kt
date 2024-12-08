package com.catenri.hogwartshall.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.catenri.data.model.Character
import com.catenri.hogwartshall.domain.GetSingleCharacterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase
): ViewModel() {
    
    private val characterId: String = checkNotNull(savedStateHandle["characterId"])
    
    private val _character = MutableStateFlow<Character?>(null)
    val character: StateFlow<Character?> = _character.asStateFlow()
    
    init {
        viewModelScope.launch {
            _character.value = getSingleCharacterUseCase(characterId)
        }
    }
}