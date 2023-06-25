package com.example.tp_final.repo

import com.example.tp_final.data.remote.GameService
import com.example.tp_final.domain.items.GameItem
import com.example.tp_final.domain.items.SpecificGameItem
import com.example.tp_final.domain.items.toGameItem
import com.example.tp_final.domain.items.toSpecificGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {

    suspend fun getGames(): List<GameItem>{

        return gameService.getGames().map{
            it.toGameItem()
        }
    }

    suspend fun getGameById(id: Int): SpecificGameItem{

        return gameService.getGameById(id).toSpecificGameItem()
    }
}