package com.example.rickandmorty.domain.state

sealed class DataState<out T> {
    data object Loading : DataState<Nothing>()

    data class Loaded<T>(val data: T) : DataState<T>()

    data class Error(val error: String) : DataState<Nothing>()
}
