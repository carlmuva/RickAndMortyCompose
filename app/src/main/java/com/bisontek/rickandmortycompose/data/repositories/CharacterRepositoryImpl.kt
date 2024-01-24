package com.bisontek.rickandmortycompose.data.repositories

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.bisontek.rickandmortycompose.data.Result
import com.bisontek.rickandmortycompose.data.source.remote.RickAndMortyApi
import com.bisontek.rickandmortycompose.data.source.remote.dto.toCharacter
import com.bisontek.rickandmortycompose.data.source.remote.dto.toListCharacters
import com.bisontek.rickandmortycompose.domain.model.Character
import com.bisontek.rickandmortycompose.domain.model.Characters
import com.bisontek.rickandmortycompose.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
):CharacterRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())
        try{
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        }catch (e:HttpException){
            emit(Result.Error(
                message = "Oops, Algo salio mal!",
                data = null
            ))
        }catch (e: IOException){
            emit(Result.Error(
                message = "No se pudo encontrar el servido, revise su conexion a internet",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try{
            api.getCharacter(id)
        }catch (e:Exception){
            return Result.Error("A ocurrido un error")
        }
        return Result.Success(response.toCharacter())
    }
}