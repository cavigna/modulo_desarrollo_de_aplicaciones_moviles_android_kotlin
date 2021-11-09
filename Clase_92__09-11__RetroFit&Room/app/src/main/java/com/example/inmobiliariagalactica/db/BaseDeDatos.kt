package com.example.inmobiliariagalactica.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inmobiliariagalactica.dao.GalacticaDao
import com.example.inmobiliariagalactica.model.Terreno
import kotlinx.coroutines.CoroutineScope


@Database(entities = [Terreno::class], version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun dao() : GalacticaDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDeDatos? = null

        fun getDataBase(context: Context): BaseDeDatos {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "galactica"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}