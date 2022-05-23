package com.nicobeltrami.rickandmortybettefly.data.remote

import com.nicobeltrami.rickandmortybettefly.data.model.CharacterResponse

class RemoteDataSource(private val service: ApiService) {
    suspend fun fetchCharacters(): CharacterResponse =
        service.fetchCharacters()
}