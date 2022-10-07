package com.musicfy.ui.trackList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.musicfy.databinding.FragmentTrackListBinding
import com.musicfy.viewmodel.TrackListViewModel
import com.musicfy.R

class TrackListFragment : Fragment() {

    private var _binding: FragmentTrackListBinding? = null
    private val binding get() = _binding!!
    private lateinit var trackListViewModel: TrackListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        trackListViewModel = ViewModelProvider(this).get(TrackListViewModel::class.java)
        _binding = FragmentTrackListBinding.inflate(inflater, container, false)

        binding.addLugarButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_addTrack)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}