package com.catenri.hogwartshall.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catenri.hogwartshall.R
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    isSearchAvailable: Boolean,
    isSearchActive: Boolean,
    query: String,
    onTabClick: () -> Unit,
    onBackClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val appBarHeight = 56.dp

    Column(modifier = modifier.height(appBarHeight)) {
        if (isSearchActive) {
            SearchField(
                query,
                onBackClick = onBackClick,
                onQueryChange = onQueryChange,
                modifier = modifier
            )
        } else {
            TopAppBar(
                modifier = modifier.fillMaxWidth(),
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    if (isSearchAvailable) {
                        IconButton(onClick = onTabClick) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = stringResource(R.string.main_screen_search_bar_content_description)
                            )
                        }
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    query: String,
    onBackClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    SearchBarDefaults.InputField(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = { },
        expanded = false,
        onExpandedChange = { },
        placeholder = { Text(stringResource(R.string.main_screen_search_placeholder)) },
        leadingIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.top_bar_navigate_back_content_description)
                )
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true, name = "Search Bar Active")
@Composable
private fun SearchTopBarActiveNoQueryPreview() {
    HogwartsHallTheme {
        SearchTopBar(
            isSearchAvailable = true,
            isSearchActive = true,
            query = "",
            onTabClick = {},
            onBackClick = {},
            onQueryChange = {}
        )
    }
}

@Preview(showBackground = true, name = "Search Bar Active")
@Composable
private fun SearchTopBarActiveWithQueryPreview() {
    HogwartsHallTheme {
        SearchTopBar(
            isSearchAvailable = true,
            isSearchActive = true,
            query = "Query",
            onTabClick = {},
            onBackClick = {},
            onQueryChange = {}
        )
    }
}

@Preview(showBackground = true, name = "Search Bar Inactive")
@Composable
private fun SearchTopBarInactivePreview() {
    HogwartsHallTheme {
        SearchTopBar(
            isSearchAvailable = true,
            isSearchActive = false,
            query = "",
            onTabClick = {},
            onBackClick = {},
            onQueryChange = {}
        )
    }
}

@Preview(showBackground = true, name = "Search Bar Inactive")
@Composable
private fun SearchTopBarWithoutSearchPreview() {
    HogwartsHallTheme {
        SearchTopBar(
            isSearchAvailable = false,
            isSearchActive = false,
            query = "",
            onTabClick = {},
            onBackClick = {},
            onQueryChange = {}
        )
    }
}
