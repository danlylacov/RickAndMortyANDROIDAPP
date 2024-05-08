package com.example.rickandmorty.ui.utils

import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.ui.model.CharacterItem

fun Character.toItem() = CharacterItem(
    id,
    name,
    status,
    species,
    gender,
    origin.name,
    location.name,
    image,
    episodesIds.size
)