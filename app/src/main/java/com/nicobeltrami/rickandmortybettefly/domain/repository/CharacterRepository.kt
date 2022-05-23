package com.nicobeltrami.rickandmortybettefly.domain.repository

import com.nicobeltrami.rickandmortybettefly.data.model.CharacterResponse

interface CharacterRepository {

    suspend fun fetchCharacters(): CharacterResponse
}
