package com.example.dictionary2.Domain.Model

data class WordItem(

    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)