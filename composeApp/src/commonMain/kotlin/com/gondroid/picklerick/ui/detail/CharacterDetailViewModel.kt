package com.gondroid.picklerick.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gondroid.picklerick.domain.Repository
import com.gondroid.picklerick.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailViewModel(
    characterModel: CharacterModel,
    private val repository: Repository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<CharacterDetailState>(CharacterDetailState(characterModel))

    val uiState: StateFlow<CharacterDetailState> = _uiState

    init {
        getEpisodesForCharacter(characterModel.episodes)
    }

    private fun getEpisodesForCharacter(episodes: List<String>) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getEpisodesForCharacter(episodes)
            }
            _uiState.update { it.copy(episodes = result) }
        }
    }
}