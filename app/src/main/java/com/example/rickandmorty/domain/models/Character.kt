package com.example.rickandmorty.domain.models

data class Character (
    val id: Long,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val gender: Gender,
    val origin: LocationName,
    val location: LocationName,
    val image: String,
    val url: String,
    val created: String,
    val episodesIds : List<Long>
)