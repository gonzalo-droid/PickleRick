package com.gondroid.picklerick.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

expect fun platformModule():Module // by platform android/ios

fun initKoin(config:KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            uiModule,
            domainModule,
            dataModule,
            platformModule()
        )
    }
}