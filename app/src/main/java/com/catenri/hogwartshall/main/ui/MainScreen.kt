package com.catenri.hogwartshall.main.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.catenri.hogwartshall.main.MainUiState
import com.catenri.hogwartshall.main.MainViewModel
import com.catenri.hogwartshall.model.CharacterUiModel
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onCharacterClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    val mainUiStaStateFlow by viewModel.mainUiStaStateFlow.collectAsStateWithLifecycle()
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var isSearchActive by rememberSaveable { mutableStateOf(false) }
    var isSearchAvailable by rememberSaveable { mutableStateOf(true) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar  = {
            SearchTopBar(
                isSearchAvailable = isSearchAvailable,
                isSearchActive = isSearchActive,
                query = searchQuery,
                onTabClick = { isSearchActive = true },
                onBackClick = {
                    isSearchActive = false
                    searchQuery = ""
                    viewModel.onSearchQueryChange(searchQuery)
                },
                onQueryChange = { newQuery ->
                    searchQuery = newQuery
                    viewModel.onSearchQueryChange(newQuery)
                },
                modifier = modifier
            )
        }
    ) { innerPadding ->
        when (mainUiStaStateFlow) {
            MainUiState.Loading -> LoadingItem()
            MainUiState.LoadFailed -> LoadFailedItem()
            is MainUiState.Success -> {
                val characters = (mainUiStaStateFlow as MainUiState.Success).characters
                CharactersItem(
                    characters = characters,
                    modifier = modifier.padding(innerPadding),
                    onCharacterClick = onCharacterClick,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadingItemPreview() {
    HogwartsHallTheme {
        MainScreen(
            onCharacterClick = {}
        )
    }
}
