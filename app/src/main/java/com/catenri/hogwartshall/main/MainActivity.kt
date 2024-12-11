package com.catenri.hogwartshall.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.catenri.hogwartshall.main.ui.LoadingItem
import com.catenri.hogwartshall.navigation.AppNavigation
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HogwartsHallTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
