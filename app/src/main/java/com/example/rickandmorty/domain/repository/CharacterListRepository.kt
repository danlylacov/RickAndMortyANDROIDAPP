package com.example.rickandmorty.domain.repository


import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.state.DataState
import kotlinx.coroutines.flow.Flow

interface CharacterListRepository {

    fun loadCharacters() : Flow<DataState<List<Character>>>
}

typealias CharactersState = DataState<List<Character>>