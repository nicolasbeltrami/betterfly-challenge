package com.nicobeltrami.rickandmortybettefly.presentation.model

interface CharacterDetailsScreenState {
    data class OnDataLoadedState(val character: CharacterState) : CharacterDetailsScreenState
}