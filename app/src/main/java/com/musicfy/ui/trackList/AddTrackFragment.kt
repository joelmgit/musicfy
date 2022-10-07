package com.musicfy.ui.trackList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.musicfy.R
import com.musicfy.databinding.FragmentAddTrackBinding
import com.musicfy.model.Track
import com.musicfy.viewmodel.TrackListViewModel

class AddTrackFragment : Fragment() {
    private var _binding: FragmentAddTrackBinding? = null
    private val binding get() = _binding!!
    private lateinit var trackListViewModel: TrackListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        trackListViewModel = ViewModelProvider(this).get(TrackListViewModel::class.java)
        _binding = FragmentAddTrackBinding.inflate(inflater, container, false)

        binding.addTrackButton.setOnClickListener { addTrack() }

        return binding.root
    }

    private fun addTrack() {
        val trackName = binding.trackNameField.text.toString()
        val author = binding.authorField.text.toString()
        val album = binding.albumField.text.toString()
        val duration = binding.durationField.text.toString()
        val trackAudioSource = binding.trackAudioSourceField.text.toString()
        val trackImageCoverSource = binding.trackImageCoverSourceField.text.toString()
        if(trackName.isNotEmpty()){
            val track = Track(0, trackName, author, album, duration,trackAudioSource,trackImageCoverSource)
            trackListViewModel.saveTrack(track);
            Toast.makeText(requireContext(),getString(R.string.text_add_track_success),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addTrack_to_nav_home)
        }else{
            Toast.makeText(requireContext(),getString(R.string.text_add_track_error),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}