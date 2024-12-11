package com.catenri.data.repository

import com.catenri.data.model.Character
import com.catenri.data.model.toEntity
import com.catenri.data.model.toExternalCharacter
import com.catenri.database.dao.CharacterDao
import com.catenri.network.service.CharactersClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Repository for the Characters with an offline-first approach
 * */
class CharactersRepositoryImpl @Inject constructor(
    private val client: CharactersClient,
    private val characterDao: CharacterDao
): CharactersRepository {

    override fun getCharacters(): Flow<List<Character>> =
        characterDao.getAll().map { characters ->
            characters.map { it.toExternalCharacter() }
        }.catch { emit(emptyList()) }

    override suspend fun getCharacter(id: String): Character =
        characterDao.get(id).toExternalCharacter()

    // TODO should this live here?
    override suspend fun synchronize() {
        val characters = client.fetchCharacters().map { it.toEntity() }
        characterDao.saveAll(characters)
    }
}
