package com.nicobeltrami.rickandmortybettefly.data.remote

import com.nicobeltrami.rickandmortybettefly.data.model.CharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun fetchCharacters() : CharacterResponse

}
