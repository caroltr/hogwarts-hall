package com.catenri.hogwartshall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catenri.data.repository.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RemoteRepository,
) : ViewModel() {

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchCharacters()
        }
    }
}