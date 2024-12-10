package com.catenri.data.repository

import com.catenri.data.model.Character
import com.catenri.data.model.toCharacter
import com.catenri.data.model.toEntity
import com.catenri.data.model.toExternalCharacter
import com.catenri.database.dao.CharacterDao
import com.catenri.network.service.HarryPotterCharactersClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Repository for the Characters with an offline-first approach
 * */
class CharactersRepositoryImpl @Inject constructor(
    private val client: HarryPotterCharactersClient,
    private val characterDao: CharacterDao
): CharactersRepository {

    override fun getCharacters(): Flow<List<Character>> =
        characterDao.getAll().map {
            it.map { it.toExternalCharacter() }
        }

//        flow {
//            emit(
//                client.fetchCharacters()
//                    .map { it.toCharacter() }
//                    .also {
//                        saveToDatabase(it)
//                    }
//            )
//        }.flowOn(Dispatchers.IO)

    override suspend fun getCharacter(id: String): Character =
                client.fetchCharacters()
                    .map { it.toCharacter() }
                    .first { it.id == id }

    private suspend fun saveToDatabase(characters: List<Character>) {
        characters.forEach {
            characterDao.insert(it.toEntity())
        }
    }
}