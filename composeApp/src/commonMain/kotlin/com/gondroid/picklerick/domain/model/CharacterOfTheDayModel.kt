package com.gondroid.picklerick.domain.model

import com.gondroid.picklerick.data.database.entity.CharacterOfTheDayEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDay:String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            isAlive =  characterModel.isAlive,
            image = characterModel.image,
            name = characterModel.name,
            selectedDay = selectedDay,
            species = characterModel.species,
            gender = characterModel.gender,
            origin = characterModel.origin,
            episodes = Json.encodeToString(characterModel.episodes)
        )
    }
}