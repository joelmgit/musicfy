package com.musicfy.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.musicfy.model.Track

@Database(entities = [Track::class],version=1, exportSchema = false)
abstract class MusicfyDatabase : RoomDatabase() {
    abstract fun lugarDao() : TrackDAO
    companion object {
        @Volatile
        private var INSTANCE: MusicfyDatabase? = null
        fun getDatabase(context: android.content.Context) : MusicfyDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    MusicfyDatabase::class.java,
                    "track_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}