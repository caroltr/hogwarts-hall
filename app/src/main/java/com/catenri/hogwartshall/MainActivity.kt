package com.catenri.hogwartshall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.catenri.data.model.Character
import com.catenri.hogwartshall.ui.theme.HogwartsColors
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HogwartsHallTheme {
                val mainUiStaStateFlow by viewModel.mainUiStaStateFlow.collectAsStateWithLifecycle()
                var searchQuery by remember { mutableStateOf("") }
                var isSearchActive by remember { mutableStateOf(false) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar  = {
                        SearchTopBarComponent(
                            isSearchActive = isSearchActive,
                            query = searchQuery,
                            onTabClick = { isSearchActive = true },
                            onSearchIconClick = {
                                isSearchActive = false
                                searchQuery = ""
                            },
                            onQueryChange = {
                                searchQuery = it
                            }
                        )
                    }
                ) { innerPadding ->
                    when (mainUiStaStateFlow) {
                        MainUiState.Loading -> LoadingComponent()
                        MainUiState.LoadFailed -> LoadFailedComponent()
                        is MainUiState.Success -> {
                            val characters = (mainUiStaStateFlow as MainUiState.Success).characters
                            val filteredCharacters = if (searchQuery.isNotEmpty()) {
                                characters.filter {
                                    it.name.contains(searchQuery, ignoreCase = true) ||
                                            it.actor.contains(searchQuery, ignoreCase = true)
                                }
                            } else {
                                characters
                            }

                            CharactersList(
                                    characters = filteredCharacters,
                                    modifier = Modifier.padding(innerPadding)
                                )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBarComponent(
    isSearchActive: Boolean,
    query: String,
    onTabClick: () -> Unit,
    onSearchIconClick: () -> Unit,
    onQueryChange: (String) -> Unit
) {
    if (isSearchActive) {
        SearchComponent(
            query,
            onIconClick = onSearchIconClick,
            onQueryChange = onQueryChange
        )
    } else {
        TopAppBar(
            title = { Text("Hogwarts Hall") },
            actions = {
                IconButton(onClick = onTabClick) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(
    query: String,
    onIconClick: () -> Unit,
    onQueryChange: (String) -> Unit
) {
    SearchBarDefaults.InputField(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = { /* no-op */ },
        expanded = false,
        onExpandedChange = { /* no-op */ },
        placeholder = { Text("Search characters") },
        leadingIcon = {
            IconButton(onClick = onIconClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun LoadingComponent() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun LoadFailedComponent() {
    Text(
        text = "Failed to load characters",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun CharactersList(
    characters: List<Character>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(characters) { character ->
            CharacterItem(character = character)
        }
    }
}

@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
    ) {
        Column {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = when (character.house.lowercase()) {
                    "gryffindor" -> HogwartsColors.gryffindor
                    "slytherin" -> HogwartsColors.slytherin
                    "ravenclaw" -> HogwartsColors.ravenclaw
                    "hufflepuff" -> HogwartsColors.hufflepuff
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = character.actor,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = character.species,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
    HogwartsHallTheme {
        CharacterItem(
            character = Character(
                actor = "Daniel",
                alive = true,
                dateOfBirth = null,
                house = "gryffindor",
                id = "",
                image = "",
                name = "Harry",
                species = "human",
                yearOfBirth = 0
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingComponentPreview() {
    HogwartsHallTheme {
        LoadingComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadFailedComponentPreview() {
    HogwartsHallTheme {
        LoadFailedComponent()
    }
}
