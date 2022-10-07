package com.musicfy.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.musicfy.data.MusicfyDatabase
import com.musicfy.model.Track
import com.musicfy.repository.TrackRepository
import kotlinx.coroutines.launch

class TrackListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TrackRepository
    private val getTracks: LiveData<List<Track>>

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        val lugarDao = MusicfyDatabase.getDatabase(application).lugarDao()
        repository = TrackRepository(lugarDao)
        getTracks = repository.getTracks
    }
    fun saveTrack(track: Track) {
        viewModelScope.launch { repository.saveTrack(track) }
    }

    fun deleteTrack(track: Track) {
        viewModelScope.launch { repository.deleteTrack(track) }
    }
}