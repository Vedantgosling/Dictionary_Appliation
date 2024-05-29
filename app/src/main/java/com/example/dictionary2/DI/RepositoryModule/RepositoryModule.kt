package com.example.dictionary2.DI.RepositoryModule

import com.example.dictionary2.Domain.Repository.DictionaryRepository
import com.example.dictionary2.data.Repository.DictionaryRepositoryimpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        dictionaryRepositoryImpl: DictionaryRepositoryimpl
    ): DictionaryRepository

}