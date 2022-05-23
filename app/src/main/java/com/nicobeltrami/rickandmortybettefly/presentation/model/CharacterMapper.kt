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

    fun fromDomainToViewCharacterViewState(character: Character): CharacterState {
        return CharacterState(
            id = character.id,
            name = character.name,
            status = character.status,
            gender = character.gender,
            image = character.image,
            species = character.species,
            origin = character.origin,
            location = character.location
        )
    }

}