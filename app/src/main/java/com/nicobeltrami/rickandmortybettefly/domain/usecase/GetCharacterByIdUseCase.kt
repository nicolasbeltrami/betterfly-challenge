package com.nicobeltrami.rickandmortybettefly.domain.usecase

import com.nicobeltrami.rickandmortybettefly.data.model.Character
import com.nicobeltrami.rickandmortybettefly.domain.repository.CharacterRepository

class GetCharacterByIdUseCase(private val repository: CharacterRepository) {
    suspend operator fun invoke(id: Int): Character =
        repository.getCharacterById(id)
}
