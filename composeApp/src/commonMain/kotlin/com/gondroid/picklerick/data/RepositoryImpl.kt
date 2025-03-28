package com.gondroid.picklerick.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import app.cash.paging.PagingData
import com.gondroid.picklerick.data.database.RickMortyDatabase
import com.gondroid.picklerick.data.remote.ApiService
import com.gondroid.picklerick.data.remote.paging.CharactersPagingSource
import com.gondroid.picklerick.data.remote.paging.EpisodesPagingSource
import com.gondroid.picklerick.domain.Repository
import com.gondroid.picklerick.domain.model.CharacterModel
import com.gondroid.picklerick.domain.model.CharacterOfTheDayModel
import com.gondroid.picklerick.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val episodesPagingSource: EpisodesPagingSource,
    private val database: RickMortyDatabase
) : Repository {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }).flow
    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { episodesPagingSource }).flow
    }

    override suspend fun getCharacterDB(): CharacterOfTheDayModel? {
        return database.getPreferencesDao().getCharacterOfTheDayDB()?.toDomain()
    }

    override suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel) {
        database.getPreferencesDao().saveCharacter(characterOfTheDayModel.toEntity())
    }

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> {

        if (episodes.isEmpty()) return emptyList()

        return if (episodes.size > 1) {
            api.getEpisodes(episodes.joinToString(",")).map { episodeResponse ->
                episodeResponse.toDomain()
            }
        } else {
            listOf(api.getSingleEpisode(episodes.first()).toDomain())
        }

    }


}