package com.bisontek.rickandmortycompose.di

import com.bisontek.rickandmortycompose.data.repositories.CharacterRepositoryImpl
import com.bisontek.rickandmortycompose.domain.repositories.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
@Binds
    abstract fun bindCharacterRepository(impl:CharacterRepositoryImpl):CharacterRepository

}