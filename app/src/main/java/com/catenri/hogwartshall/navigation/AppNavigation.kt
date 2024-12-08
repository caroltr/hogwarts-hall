package com.catenri.hogwartshall.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.catenri.hogwartshall.detail.DetailScreen
import com.catenri.hogwartshall.main.MainScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.CharactersList.route) {
        composable(NavRoute.CharactersList.route) {
            MainScreen(
                onCharacterClick = { character ->
                    navController.navigate(NavRoute.CharacterDetail.createRoute(character.id))
                }
            )
        }
        composable(
            route = NavRoute.CharacterDetail.route,
            arguments = listOf(navArgument("characterId") { type = NavType.StringType })
        ) {
            DetailScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
