package com.example.rickandmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmorty.databinding.FragmentEpisodeListBinding
import com.example.rickandmorty.databinding.FragmentLocationsListBinding

class EpisodeListFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}