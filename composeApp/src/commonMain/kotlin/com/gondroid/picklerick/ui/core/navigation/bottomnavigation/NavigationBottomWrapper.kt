package com.gondroid.picklerick.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gondroid.picklerick.ui.core.navigation.Routes
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun NavigationBottomWrapper(navController: NavHostController, mainNavController: NavHostController){

    NavHost(navController = navController, startDestination = Routes.Episodes.route){

        composable(route = Routes.Episodes.route){
        }

        composable(route = Routes.Characters.route){

        }
    }

}