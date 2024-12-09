package com.catenri.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.catenri.database.dao.CharacterDao
import com.catenri.database.model.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
internal abstract class HogwartsHallDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}