package com.bisontek.rickandmortycompose.domain.use_case

import com.bisontek.rickandmortycompose.data.Result
import com.bisontek.rickandmortycompose.domain.model.Character
import com.bisontek.rickandmortycompose.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character> {
        return repository.getCharacter(id)
    }
}