package com.gondroid.picklerick.di

import com.gondroid.picklerick.ui.detail.CharacterDetailViewModel
import com.gondroid.picklerick.ui.home.tabs.characteres.CharactersViewModel
import com.gondroid.picklerick.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
    viewModelOf(::CharacterDetailViewModel)
}