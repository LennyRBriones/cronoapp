package com.lennyrbriones.cronoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lennyrbriones.cronoapp.model.Cronos


@Database(entities = [Cronos::class], version = 1, exportSchema = false)
abstract class CronosDatabase: RoomDatabase() {
    abstract fun cronosDao() : CronosDatabaseDao
}