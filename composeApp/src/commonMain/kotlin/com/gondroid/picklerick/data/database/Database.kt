package com.gondroid.picklerick.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.gondroid.picklerick.data.database.dao.UserPreferencesDAO
import com.gondroid.picklerick.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_app_database.db"

expect object RickMortyCTor:RoomDatabaseConstructor<RickMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 2)
@ConstructedBy(RickMortyCTor::class)
abstract class RickMortyDatabase:RoomDatabase(){
    abstract fun getPreferencesDao():UserPreferencesDAO
}