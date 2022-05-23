package com.nicobeltrami.rickandmortybettefly.presentation.model

interface CharacterDetailsScreenState {
    object OnDataLoadingState : CharacterDetailsScreenState
    data class OnDataLoadedState(val character: CharacterState) : CharacterDetailsScreenState
}