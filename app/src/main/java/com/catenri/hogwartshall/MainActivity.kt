package com.catenri.hogwartshall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
        enableEdgeToEdge()
        setContent {
            HogwartsHallTheme {
                val mainUiStaStateFlow by viewModel.mainUiStaStateFlow.collectAsStateWithLifecycle()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (mainUiStaStateFlow) {
                        MainUiState.Loading -> LoadingComponent()
                        MainUiState.LoadFailed -> LoadFailedComponent()
                        is MainUiState.Success -> {
                            CharactersList(
                                    characters = (mainUiStaStateFlow as MainUiState.Success).characters,
                                    modifier = Modifier.padding(innerPadding)
                                )
                        }
                    }
                }
            }
        }
    }
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
                house = "Gryphyndor",
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
