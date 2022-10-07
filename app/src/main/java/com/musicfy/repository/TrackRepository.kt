package com.musicfy.repository

import androidx.lifecycle.LiveData
import com.musicfy.data.TrackDAO
import com.musicfy.model.Track

class TrackRepository(private val trackDAO: TrackDAO) {
    suspend fun saveTrack(track: Track) {
        if(track.id == 0){
            trackDAO.addTrack(track)
        }else{
            trackDAO.updateTrack(track)
        }
        trackDAO.addTrack(track)
    }
    suspend fun deleteTrack(track: Track) {
        trackDAO.deleteTrack(track)
    }
    val getTracks : LiveData<List<Track>> = trackDAO.getTracks()
}