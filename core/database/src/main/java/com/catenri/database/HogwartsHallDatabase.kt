package com.catenri.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.catenri.database.dao.CharacterDao
import com.catenri.database.model.CharacterEntity
import com.catenri.database.util.InstantConverter

@Database(entities = [CharacterEntity::class], version = 1)
@TypeConverters(InstantConverter::class)
internal abstract class HogwartsHallDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}