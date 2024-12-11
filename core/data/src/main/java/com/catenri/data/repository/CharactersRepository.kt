package com.catenri.data.repository

import com.catenri.data.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters(): Flow<List<Character>>

    suspend fun getCharacter(id: String): Character

    suspend fun synchronize()
}
