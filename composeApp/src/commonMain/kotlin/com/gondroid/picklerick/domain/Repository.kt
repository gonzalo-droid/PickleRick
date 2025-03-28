package com.gondroid.picklerick.domain

import app.cash.paging.PagingData
import com.gondroid.picklerick.domain.model.CharacterModel
import com.gondroid.picklerick.domain.model.CharacterOfTheDayModel
import com.gondroid.picklerick.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel)
    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>
}