package com.nicobeltrami.rickandmortybettefly.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results")
    val results: List<Character>
)
