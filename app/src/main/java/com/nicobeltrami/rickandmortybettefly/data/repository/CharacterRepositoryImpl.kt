package com.nicobeltrami.rickandmortybettefly.data.repository

import com.nicobeltrami.rickandmortybettefly.data.model.Character
import com.nicobeltrami.rickandmortybettefly.data.model.CharacterResponse
import com.nicobeltrami.rickandmortybettefly.data.remote.RemoteDataSource
import com.nicobeltrami.rickandmortybettefly.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val datasource: RemoteDataSource) : CharacterRepository {
    override suspend fun fetchCharacters(): CharacterResponse =
        datasource.fetchCharacters()

    override suspend fun getCharacterById(id: Int) : Character =
        datasource.getCharacterById(id)
}
