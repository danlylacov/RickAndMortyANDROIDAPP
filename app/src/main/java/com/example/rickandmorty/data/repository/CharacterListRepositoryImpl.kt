package com.example.rickandmorty.data.repository

import com.example.rickandmorty.domain.models.CharacterStatus
import com.example.rickandmorty.domain.models.Gender
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.models.LocationName
import com.example.rickandmorty.domain.repository.CharacterListRepository
import com.example.rickandmorty.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterListRepositoryImpl: CharacterListRepository {

    override fun loadCharacters(): Flow<DataState<List<Character>>> =  flow {
        emit(DataState.Loading)
        delay(1000)
        emit(DataState.Loaded<List<Character>>(
           genCharacters()
        ))
    }

    private fun genCharacters() = listOf(
        Character(
            0,
            "Pro trunk people marrige guy",
            CharacterStatus.ALIVE,
            "Human",
            Gender.MALE,
            LocationName(0L, "Cable"),
            LocationName(0L, "Cable"),
            "Earth",
            "",
            "",
            emptyList()
        )
    )
}