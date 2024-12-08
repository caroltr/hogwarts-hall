package com.catenri.hogwartshall.navigation

sealed class NavRoute(val route: String) {
    object CharactersList : NavRoute("characters_list")
    object CharacterDetail : NavRoute("character_detail/{characterId}") {
        fun createRoute(characterId: String) = "character_detail/$characterId"
    }
}
