package com.example.rickandmorty.domain.models

data class Location(
    val id: Long,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String,
    val created: String,
    val residentUds: List<Long>
)
