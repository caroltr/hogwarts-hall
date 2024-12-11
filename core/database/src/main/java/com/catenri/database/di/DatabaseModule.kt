package com.catenri.database.di

import android.content.Context
import androidx.room.Room
import com.catenri.database.HogwartsHallDatabase
import com.catenri.database.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "hogwarts_hall_database"

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): HogwartsHallDatabase {
        return Room.databaseBuilder(
            appContext,
            HogwartsHallDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(appDatabase: HogwartsHallDatabase) : CharacterDao {
        return appDatabase.characterDao()
    }
}
