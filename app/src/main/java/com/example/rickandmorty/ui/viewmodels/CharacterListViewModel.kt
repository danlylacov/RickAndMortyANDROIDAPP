package com.example.rickandmorty.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.repository.CharacterListRepository
import com.example.rickandmorty.domain.repository.CharactersState
import com.example.rickandmorty.domain.state.DataState
import com.example.rickandmorty.domain.usecase.LoadCharacterUseCase
import com.example.rickandmorty.ui.model.CharacterItem
import com.example.rickandmorty.ui.utils.toItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val loadCharacterUseCase: LoadCharacterUseCase
) : ViewModel(){


    private val _characters: MutableLiveData<CharactersState> = MutableLiveData<CharactersState>().apply {
        value = DataState.Loading
    }

    val characters: LiveData<DataState<List<CharacterItem>>>
        get() = _characters.map { state -> when(state) {
            is DataState.Loading -> state
            is DataState.Error -> state
            is DataState.Loaded -> DataState.Loaded(
                state.data.map { it.toItem() }
            )
    }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadCharacterUseCase().collect {
                _characters.postValue(it)
            }
        }
    }


    class Factory(
        private val repository: CharacterListRepository
    ) : ViewModelProvider.Factory{

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CharacterListViewModel(
                LoadCharacterUseCase(repository)
            ) as T
        }

    }
}