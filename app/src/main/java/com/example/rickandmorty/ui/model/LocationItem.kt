package com.example.rickandmorty.ui.model

data class LocationItem(
    override val id: Long,
    override val name: String,
    val type: String,
    val dimension: String,
    val residents: Int
): Item
