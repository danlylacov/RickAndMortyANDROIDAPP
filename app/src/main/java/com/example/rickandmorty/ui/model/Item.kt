package com.example.rickandmorty.ui.model

sealed interface Item {
    val id: Long
    val name: String
}