package com.example.rickandmorty.domain.models

data class Episode(
    val id: Long,
    val name: String,
    val air_date: String,
    val url: String,
    val created: String,
    val characterIds: List<Long>
)