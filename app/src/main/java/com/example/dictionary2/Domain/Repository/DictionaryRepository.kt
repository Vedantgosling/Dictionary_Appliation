package com.example.dictionary2.Domain.Repository

import com.example.dictionary2.Domain.Model.WordItem
import com.example.dictionary2.Util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>
}