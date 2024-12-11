package com.catenri.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.catenri.database.model.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character ORDER BY id DESC")
    fun getAll(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun get(id: String): CharacterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(characters: List<CharacterEntity>)
}
