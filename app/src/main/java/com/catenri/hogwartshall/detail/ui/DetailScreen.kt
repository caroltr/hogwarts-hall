package com.catenri.hogwartshall.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.catenri.hogwartshall.R
import com.catenri.hogwartshall.common.ui.houseColor
import com.catenri.hogwartshall.detail.DetailViewModel
import com.catenri.hogwartshall.model.CharacterUiModel
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val character by viewModel.character.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.top_bar_navigate_back_content_description)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        character?.let { char ->
            CharacterDetail(
                character = char,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun CharacterDetail(
    character: CharacterUiModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HeaderContent(character)

        BottomContent(character)
    }
}

@Composable
private fun HeaderContent(
    character: CharacterUiModel
) {
    Box {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(character.image)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.detail_screen_picture_content_description, character.name),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        ),
                        startY = 300f
                    )
                )
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .align(Alignment.BottomCenter),
            color = houseColor(character.house.lowercase())
        )
    }
}

@Composable
private fun BottomContent(
    character: CharacterUiModel
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            LifeStatusBadge(isAlive = character.alive)
        }

        DescriptionItem(
            label = stringResource(R.string.detail_screen_bottom_content_portrayed_by_label),
            value = character.actor,
            icon = Icons.Outlined.Person
        )

        DescriptionItem(
            label = stringResource(R.string.detail_screen_bottom_content_species_label),
            value = character.species,
            icon = Icons.Outlined.LocationOn
        )

        if (character.house.isNotBlank()) {
            DescriptionItem(
                label = stringResource(R.string.detail_screen_bottom_content_house_label),
                value = character.house,
                icon = Icons.Outlined.Home
            )
        }

        character.dateOfBirth?.let { dob ->
            DescriptionItem(
                label = stringResource(R.string.detail_screen_bottom_content_date_of_birth_label),
                value = dob,
                icon = Icons.Outlined.Call
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderContentPreview() {
    HogwartsHallTheme {
        HeaderContent(characterComplete)
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomContentCompleteInfoPreview() {
    HogwartsHallTheme {
        BottomContent(characterComplete)
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomContentMissingInfoPreview() {
    HogwartsHallTheme {
        BottomContent(characterMissingInfo)
    }
}

private val characterComplete = CharacterUiModel(
    actor = "Daniel Radcliffe",
    alive = true,
    dateOfBirth = "31 12 2024",
    house = "human",
    id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
    image = "",
    name = "Harry Potter",
    species = "human",
)

// TODO update with info that can actually be missed
// analyse response for that
private val characterMissingInfo = CharacterUiModel(
    actor = "Daniel Radcliffe",
    alive = true,
    dateOfBirth = "31 12 2000",
    house = "human",
    id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
    image = "",
    name = "Harry Potter",
    species = "",
)

