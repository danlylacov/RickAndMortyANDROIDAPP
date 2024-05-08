package com.example.rickandmorty.ui.model

data class EpisodeItem(
    override val id: Long,
    override val name: String,
    val airdate: String,
    val episode: String,
    val character : Int

) : Item
