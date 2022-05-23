package com.nicobeltrami.rickandmortybettefly.domain.usecase

import com.nicobeltrami.rickandmortybettefly.data.model.CharacterResponse
import com.nicobeltrami.rickandmortybettefly.domain.repository.CharacterRepository

class FetchCharactersUseCase(private val repository: CharacterRepository) {
    suspend operator fun invoke() : CharacterResponse {
        return repository.fetchCharacters()
    }
}