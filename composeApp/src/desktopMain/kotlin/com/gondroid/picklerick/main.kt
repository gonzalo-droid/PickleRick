package com.gondroid.picklerick

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.isTraySupported
import androidx.compose.ui.window.rememberTrayState
import com.gondroid.picklerick.di.initKoin
import dev.datlag.kcef.KCEF
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.painterResource
import picklerick.composeapp.generated.resources.Res
import picklerick.composeapp.generated.resources.portal
import java.io.File
import kotlin.math.max

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Rick and Morty APP"
    ) {
        var restartRequired by remember { mutableStateOf(false) }
        var downloading by remember { mutableStateOf(0F) }
        var initialized by remember { mutableStateOf(false) }
        var trayState = rememberTrayState()
        if (isTraySupported) {
            Tray(
                state = trayState,
                icon = painterResource(Res.drawable.portal),
                menu = {
                    Item("Cerrar", onClick = { exitApplication() })
                    Item("Pepe", onClick = { exitApplication() })
                    Item("Hola", onClick = { exitApplication() })
                    Item("Cerrar", onClick = { exitApplication() })
                }
            )
        }

        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                KCEF.init(builder = {
                    installDir(File("kcef-bundle"))
                    progress {
                        onDownloading {
                            downloading = max(it, 0F)
                        }
                        onInitialized {
                            initialized = true
                        }
                    }
                    settings {
                        cachePath = File("cache").absolutePath
                    }
                }, onError = {
                    it?.printStackTrace()
                }, onRestartRequired = {
                    restartRequired = true
                })
            }
        }


//        if (restartRequired) {
//            Text(text = "Restart required.")
//        } else {
//            if (initialized) {
        initKoin()
        App()
//                UtilsScreen()
//            } else {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier.background(BackgroundPrimaryColor).fillMaxSize()
//                ) {
//                    CircularProgressIndicator(color = Green)
//                    Text(text = "Downloading $downloading%")
//                }
//            }
    }

    DisposableEffect(Unit) {
        onDispose {
            KCEF.disposeBlocking()
        }
    }
}
//}