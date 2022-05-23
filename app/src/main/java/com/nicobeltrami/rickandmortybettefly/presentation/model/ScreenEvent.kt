package com.nicobeltrami.rickandmortybettefly.presentation.model

sealed interface ScreenEvent {
    object OnInitEvent: ScreenEvent
}