package com.example.dictionary2.data.DTO

data class MeaningDto(
    val definitions: List<DefinitionDto>?= null,
    val partOfSpeech: String?= null,

    )