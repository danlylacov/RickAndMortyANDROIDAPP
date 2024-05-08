package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.repository.CharacterListRepository
import com.example.rickandmorty.domain.repository.CharactersState
import kotlinx.coroutines.flow.Flow

class LoadCharacterUseCase(private val repository: CharacterListRepository) {

    operator fun invoke(): Flow<CharactersState> = repository.loadCharacters()
}