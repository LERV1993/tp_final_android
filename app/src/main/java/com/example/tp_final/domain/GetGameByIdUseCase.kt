package com.example.tp_final.domain

import com.example.tp_final.domain.items.SpecificGameItem
import com.example.tp_final.repo.GameRepository
import javax.inject.Inject

class GetGameByIdUseCase @Inject constructor( private val gameRepository: GameRepository) {

    suspend operator fun invoke(id: Int): SpecificGameItem {

        return gameRepository.getGameById(id)

    }

}