package com.nicobeltrami.rickandmortybettefly.presentation.model

import com.nicobeltrami.rickandmortybettefly.data.model.Location
import com.nicobeltrami.rickandmortybettefly.data.model.Origin

data class CharacterState(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val image: String,
    val species: String,
    val origin: Origin,
    val location: Location
)
