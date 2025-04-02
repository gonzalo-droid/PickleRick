package com.gondroid.picklerick.di

import com.gondroid.picklerick.data.database.RickMortyDatabase
import com.gondroid.picklerick.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDatabase() }
    }
}