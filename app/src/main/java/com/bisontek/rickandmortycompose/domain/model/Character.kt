package com.bisontek.rickandmortycompose.domain.model

import com.bisontek.rickandmortycompose.data.source.remote.dto.Location
import com.bisontek.rickandmortycompose.data.source.remote.dto.Origin

data class Character(
    val id:Int,
    val name:String,
    val status:String,
    val species:String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image:String
)
