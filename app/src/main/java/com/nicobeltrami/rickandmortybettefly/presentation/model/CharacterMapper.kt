package com.nicobeltrami.rickandmortybettefly.presentation.model

import com.nicobeltrami.rickandmortybettefly.data.model.Character

object CharacterMapper {

    fun fromDomainToViewState(characters: List<Character>): List<CharacterState> {
        return characters.map { CharacterState(
            id = it.id,
            name = it.name,
            status = it.status,
            gender = it.gender,
            image = it.image,
            species = it.species,
            origin = it.origin,
            location = it.location
        ) }
    }

}