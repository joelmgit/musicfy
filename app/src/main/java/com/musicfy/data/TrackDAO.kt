package com.musicfy.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.musicfy.model.Track
@Dao
interface TrackDAO {
    //CRUD  = Create Read Update Delete

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrack(track: Track)
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTrack(track: Track)
    @Delete
    suspend fun deleteTrack(track: Track)
    @Query ("SELECT * FROM TRACK")
    fun getTracks() : LiveData<List<Track>>
}