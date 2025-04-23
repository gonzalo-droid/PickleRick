package com.gondroid.picklerick.data.remote.response

import com.gondroid.picklerick.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id") val id: Int,
    val status: String,
    val image: String,
    val name:String,
    val species:String,
    val gender:String,
    val origin:OriginResponse,
    val episode:List<String> // room dont reconice List
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            image = image,
            isAlive = status.lowercase() == "alive",
            name = name,
            species = species,
            gender = gender,
            origin = origin.name,
            episodes = episode.map { it.substringAfterLast("/") }
        )
    }
}