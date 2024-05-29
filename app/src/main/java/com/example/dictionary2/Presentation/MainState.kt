package com.example.dictionary2.Presentation

import com.example.dictionary2.Domain.Model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",

    val wordItem: WordItem? = null
)