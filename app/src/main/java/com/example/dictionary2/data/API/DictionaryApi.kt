package com.example.dictionary2.data.API

import com.example.dictionary2.data.DTO.WordResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi{
    @GET("{word}")
    suspend fun getWordResult(
        @Path("word") word: String
    ): WordResultDto?

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }

}