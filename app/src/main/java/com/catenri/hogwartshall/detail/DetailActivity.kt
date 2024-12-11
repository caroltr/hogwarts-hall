package com.catenri.hogwartshall.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.catenri.hogwartshall.detail.ui.DetailScreen
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HogwartsHallTheme {
                DetailScreen(
                    onBackClick = { finish() }
                )
            }
        }
    }
}
