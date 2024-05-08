package com.example.rickandmorty.ui.model

import com.example.rickandmorty.domain.models.CharacterStatus
import com.example.rickandmorty.domain.models.Gender

data class CharacterItem(
    override val id: Long,
    override val name: String,
    val status: CharacterStatus,
    val spesies: String,
    val gender: Gender,
    val origin: String,
    val image: String,
    val location : String,
    val episodes : Int
) : Item
