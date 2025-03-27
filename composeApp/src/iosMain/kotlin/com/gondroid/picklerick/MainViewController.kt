package com.gondroid.picklerick

import androidx.compose.ui.window.ComposeUIViewController
import com.gondroid.picklerick.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }