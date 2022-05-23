package com.nicobeltrami.rickandmortybettefly.presentation.model

sealed interface CharacterDetailsScreenState {
    object OnDataLoadingState : CharacterDetailsScreenState
    data class OnDataLoadedState(val character: CharacterState) : CharacterDetailsScreenState
}