package com.nicobeltrami.rickandmortybettefly.presentation.model

sealed interface CharacterDetailsScreenEvent {
    data class OnInitEvent(val id: Int): CharacterDetailsScreenEvent
}