package com.catenri.hogwartshall.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catenri.hogwartshall.common.ui.houseColor
import com.catenri.hogwartshall.model.CharacterHouse
import com.catenri.hogwartshall.model.CharacterUiModel
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@Composable
internal fun CharactersItem(
    characters: List<CharacterUiModel>,
    onCharacterClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
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
internal fun CharacterItem(
    character: CharacterUiModel,
    onCharacterClick: (CharacterUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        onClick = { onCharacterClick(character) }
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            character.house?.let { house ->
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(houseColor(house))
                        .align(Alignment.TopEnd),

                )
            }

            Column(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
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
                house = CharacterHouse.GRYFFINDOR,
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
                house = CharacterHouse.SLYTHERIN,
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
                house = CharacterHouse.RAVENCLAW,
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
                house = CharacterHouse.HUFFLEPUFF,
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
                house = null,
                id = "",
                image = "",
                name = "Harry",
                species = "",
            ),
            onCharacterClick = { }
        )
    }
}
