package com.example.dictionary2.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary2.Domain.Repository.DictionaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.dictionary2.Util.Result


@HiltViewModel
class MainViewModel @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
): ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    private var searchjob: Job? = null

    init {
        _mainState.update {
            it.copy(searchWord = "Word")
        }
        searchjob?.cancel()
        searchjob = viewModelScope.launch {
            loadWordResult()
        }
    }

    fun onEvent(mainUiEvent: MainUiEvents) {
        when (mainUiEvent) {
            MainUiEvents.OnSearchClick -> {
                searchjob?.cancel()
                searchjob = viewModelScope.launch {
                    loadWordResult()
                }

            }

            is MainUiEvents.OnSearchWordChange -> {
                _mainState.update {
                    it.copy(
                        searchWord = mainUiEvent.newWord.lowercase()
                    )
                }
            }
        }
    }

    private fun loadWordResult() {
        viewModelScope.launch {
            dictionaryRepository.getWordResult(
                mainState.value.searchWord
            ).collect { result ->
                when(result) {

                    is Result.Loading -> {
                        _mainState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Result.Error -> Unit

                    is Result.Success -> {
                        result.data?.let { wordItem ->
                            _mainState.update {
                                it.copy(
                                    wordItem = wordItem
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}













