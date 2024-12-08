package com.catenri.data.repository

import com.catenri.data.model.Character
import com.catenri.data.model.toCharacter
import com.catenri.network.service.HarryPotterCharactersClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val client: HarryPotterCharactersClient
): CharactersRepository {

    override fun fetchCharacters(): Flow<List<Character>> =
        flow {
            emit(
                client.fetchCharacters()
                    .map { it.toCharacter() }
            )
        }.flowOn(Dispatchers.IO)

    override suspend fun getCharacter(id: String): Character =
                client.fetchCharacters()
                    .map { it.toCharacter() }
                    .first { it.id == id }
}