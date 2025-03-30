package com.gondroid.picklerick.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gondroid.picklerick.domain.model.CharacterModel
import com.gondroid.picklerick.ui.home.HomeScreen
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen(mainNavController)
        }

        composable<CharacterDetail> { navBackStackEntry ->
            val characterDetailEncoding: CharacterDetail =
                navBackStackEntry.toRoute<CharacterDetail>()
            val characterModel: CharacterModel =
                Json.decodeFromString<CharacterModel>(characterDetailEncoding.characterModel)
            CharacterDetailScreen(
                characterModel = characterModel,
                onBackPressed = { mainNavController.popBackStack() })
        }
    }

}