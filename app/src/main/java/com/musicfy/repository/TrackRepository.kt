package com.musicfy.repository

import androidx.lifecycle.LiveData
import com.musicfy.data.TrackDAO
import com.musicfy.model.Track

class TrackRepository(private val lugarDao: TrackDAO) {
    suspend fun saveTrack(track: Track) {
        if(track.id == 0){
            lugarDao.addTrack(track)
        }else{
            lugarDao.updateTrack(track)
        }
        lugarDao.addTrack(track)
    }
    suspend fun deleteTrack(track: Track) {
        lugarDao.deleteTrack(track)
    }
    val getTracks : LiveData<List<Track>> = lugarDao.getTracks()
}