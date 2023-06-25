package com.example.tp_final.data.remote

import com.example.tp_final.data.remote.models.GameModel
import com.example.tp_final.data.remote.models.SpecificGameModel
import com.example.tp_final.util.Constants.Companion.GAMES_ENDPOINT
import com.example.tp_final.util.Constants.Companion.GAME_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<SpecificGameModel>
}