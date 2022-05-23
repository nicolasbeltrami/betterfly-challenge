package com.nicobeltrami.rickandmortybettefly.data.remote

import com.nicobeltrami.rickandmortybettefly.data.model.Character
import com.nicobeltrami.rickandmortybettefly.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun fetchCharacters() : CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : Character

}
