package com.bisontek.rickandmortycompose.domain.use_case

import com.bisontek.rickandmortycompose.data.Result
import com.bisontek.rickandmortycompose.domain.model.Characters
import com.bisontek.rickandmortycompose.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun  invoke(page:Int): Flow<Result<List<Characters>>> {
        return repository.getCharacters(page)
    }
}