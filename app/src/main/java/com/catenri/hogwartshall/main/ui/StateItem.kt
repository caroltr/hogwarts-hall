package com.catenri.hogwartshall.main.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.catenri.hogwartshall.R
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun LoadFailedItem() {
    Text(
        text = stringResource(R.string.warning_message_load_failed),
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}


@Preview(showBackground = true)
@Composable
private fun LoadingItemPreview() {
    HogwartsHallTheme {
        LoadingItem()
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadFailedItemPreview() {
    HogwartsHallTheme {
        LoadFailedItem()
    }
}