package com.gondroid.picklerick.ui.home.tabs.characteres

import app.cash.paging.PagingData
import com.gondroid.picklerick.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState(
    val characterOfTheDay:CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)