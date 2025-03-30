package com.gondroid.picklerick.ui.detail

import com.gondroid.picklerick.domain.model.CharacterModel
import com.gondroid.picklerick.domain.model.EpisodeModel

data class CharacterDetailState(
    val characterModel: CharacterModel,
    val episodes:List<EpisodeModel>? = null
)