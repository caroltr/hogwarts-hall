package com.catenri.hogwartshall.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catenri.hogwartshall.common.ui.houseColor
import com.catenri.hogwartshall.model.CharacterUiModel
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@Composable
fun CharactersItem(
    characters: List<CharacterUiModel>,
    onCharacterClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(characters) { character ->
            CharacterItem(
                character = character,
                onCharacterClick = onCharacterClick
            )
        }
    }
}

@Composable
fun CharacterItem(
    character: CharacterUiModel,
    onCharacterClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        onClick = { onCharacterClick(character) }
    ) {
        Column {
            HorizontalDivider(
                modifier = modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = houseColor(character.house.lowercase())
            )
            Column(
                modifier = modifier
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

@Preview(showBackground = true, name = "Character Gryffindor")
@Composable
private fun CharacterItemPreview() {
    HogwartsHallTheme {
        CharacterItem(
            character = CharacterUiModel(
                actor = "Daniel",
                alive = true,
                dateOfBirth = null,
                house = "gryffindor",
                id = "",
                image = "",
                name = "Harry",
                species = "human",
            ),
            onCharacterClick = { }
        )
    }
}

@Preview(showBackground = true, name = "Character Slytherin")
@Composable
private fun CharacterSlytherinPreview() {
    HogwartsHallTheme {
        CharacterItem(
            character = CharacterUiModel(
                actor = "Daniel",
                alive = true,
                dateOfBirth = null,
                house = "slytherin",
                id = "",
                image = "",
                name = "Harry",
                species = "",
            ),
            onCharacterClick = { }
        )
    }
}

@Preview(showBackground = true, name = "Character Ravenclaw")
@Composable
private fun CharacterRavenclawPreview() {
    HogwartsHallTheme {
        CharacterItem(
            character = CharacterUiModel(
                actor = "Daniel",
                alive = true,
                dateOfBirth = null,
                house = "ravenclaw",
                id = "",
                image = "",
                name = "Harry",
                species = "",
            ),
            onCharacterClick = { }
        )
    }
}

@Preview(showBackground = true, name = "Character Hufflepuff")
@Composable
private fun CharacterHufflepuffPreview() {
    HogwartsHallTheme {
        CharacterItem(
            character = CharacterUiModel(
                actor = "Daniel",
                alive = true,
                dateOfBirth = null,
                house = "hufflepuff",
                id = "",
                image = "",
                name = "Harry",
                species = "",
            ),
            onCharacterClick = { }
        )
    }
}

@Preview(showBackground = true, name = "Character missing information")
@Composable
private fun CharacterMissingInfoPreview() {
    HogwartsHallTheme {
        CharacterItem(
            character = CharacterUiModel(
                actor = "Daniel",
                alive = true,
                dateOfBirth = null,
                house = "",
                id = "",
                image = "",
                name = "Harry",
                species = "",
            ),
            onCharacterClick = { }
        )
    }
}
