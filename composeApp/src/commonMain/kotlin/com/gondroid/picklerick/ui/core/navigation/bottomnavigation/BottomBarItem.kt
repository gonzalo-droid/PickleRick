package com.gondroid.picklerick.ui.core.navigation.bottomnavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gondroid.picklerick.ui.core.navigation.Routes

sealed class BottomBarItem {
    abstract val route: String
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    data class Episodes(
        override val route: String = Routes.Episodes.route,
        override val title: String = "Episodes",
        override val icon: @Composable () -> Unit = {
            Icon(
                imageVector = Icons.Default.Home, //painterResource(Res.drawable.ic_player),
                "",
                modifier = Modifier.size(24.dp)
            )
        }
    ) : BottomBarItem()

    data class Characters(
        override val route: String = Routes.Characters.route,
        override val title: String = "Characters",
        override val icon: @Composable () -> Unit = {
            Icon(
                imageVector = Icons.Default.Person, // painterResource(Res.drawable.ic_characters),
                "",
                modifier = Modifier.size(24.dp)
            )
        }
    ) : BottomBarItem()
}