package com.lennyrbriones.cronoapp.di

import android.content.Context
import androidx.room.Room
import com.lennyrbriones.cronoapp.room.CronosDatabase
import com.lennyrbriones.cronoapp.room.CronosDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providesCronosDao(cronosDatabase: CronosDatabase) : CronosDatabaseDao {
        return cronosDatabase.cronosDao()
    }
    //Return the database to use the functions


    @Singleton
    @Provides
    fun providesCronosDatabase(@ApplicationContext context: Context) : CronosDatabase {
        return Room.databaseBuilder(
            context,
            CronosDatabase::class.java, "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}