package com.example.dictionary2.Presentation

sealed class MainUiEvents {

    data class OnSearchWordChange(
        val newWord: String
    ) : MainUiEvents()

    object OnSearchClick : MainUiEvents()
}