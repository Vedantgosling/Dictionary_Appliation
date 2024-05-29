package com.example.dictionary2.data.DTO

data class WordItemDto(

    val meanings: List<MeaningDto>?= null,
    val phonetic: String ?= null,
    val word: String?= null
)