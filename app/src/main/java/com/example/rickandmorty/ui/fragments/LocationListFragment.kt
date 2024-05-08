package com.example.rickandmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.databinding.FragmentLocationBinding
import com.example.rickandmorty.databinding.FragmentLocationsListBinding

class LocationListFragment : Fragment() {

    private lateinit var binding: FragmentLocationsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationsListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}