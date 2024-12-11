package com.catenri.data.di

import com.catenri.data.repository.CharactersRepository
import com.catenri.data.repository.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindCharactersRepository(
        impl: CharactersRepositoryImpl
    ): CharactersRepository
}
