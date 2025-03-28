package com.gondroid.picklerick

import android.app.Application
import com.gondroid.picklerick.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class PickleRickApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger() // logging in DI Koin
            androidContext(this@PickleRickApp) // inject context
        }

    }
}