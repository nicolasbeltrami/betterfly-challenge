package com.nicobeltrami.rickandmortybettefly.presentation.model

sealed interface ScreenState {
    object OnLoadingState: ScreenState
    data class OnLoadedState(val charactersList: List<CharacterState>): ScreenState
}