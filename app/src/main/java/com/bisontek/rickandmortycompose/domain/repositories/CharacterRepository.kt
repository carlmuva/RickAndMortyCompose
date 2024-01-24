package com.bisontek.rickandmortycompose.domain.repositories

import com.bisontek.rickandmortycompose.data.Result
import com.bisontek.rickandmortycompose.domain.model.Character
import com.bisontek.rickandmortycompose.domain.model.Characters
import kotlinx.coroutines.flow.Flow


interface CharacterRepository {

    //Cuando se usa flow no es necesario usar suspend
    fun getCharacters(page: Int): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id:Int):Result<Character>

}