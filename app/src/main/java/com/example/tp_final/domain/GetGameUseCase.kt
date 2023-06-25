package com.example.tp_final.domain

import com.example.tp_final.domain.items.GameItem
import com.example.tp_final.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(private val gameRepository: GameRepository){

    suspend operator fun invoke(): List<GameItem>{

        return gameRepository.getGames().shuffled()
    }

}