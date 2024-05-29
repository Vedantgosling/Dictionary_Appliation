package com.example.dictionary2.data.Mapper

import com.example.dictionary2.Domain.Model.Definition
import com.example.dictionary2.Domain.Model.Meaning
import com.example.dictionary2.Domain.Model.WordItem
import com.example.dictionary2.data.DTO.DefinitionDto
import com.example.dictionary2.data.DTO.MeaningDto
import com.example.dictionary2.data.DTO.WordItemDto


fun WordItemDto.toWordItem() = WordItem (
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)