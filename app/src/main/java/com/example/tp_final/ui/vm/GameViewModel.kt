package com.example.tp_final.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_final.domain.GetGameByIdUseCase
import com.example.tp_final.domain.GetGameUseCase
import com.example.tp_final.domain.items.GameItem
import com.example.tp_final.domain.items.SpecificGameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGameUseCase: GetGameUseCase,
    private val getGameByIdUseCase: GetGameByIdUseCase
) : ViewModel() {

    private val _games = MutableLiveData<List<GameItem>>()
    val games: LiveData<List<GameItem>> get() = _games

    private val _game = MutableLiveData<SpecificGameItem>()
    val game: LiveData<SpecificGameItem> get() = _game

    init {
        getGames()
    }

    private fun getGames(){

        viewModelScope.launch {

            try{

                val games = getGameUseCase()
                _games.value = games

            } catch(_: Exception) {}

        }

    }

    fun getGameById(id: Int){

        viewModelScope.launch {

            try{

                val game = getGameByIdUseCase(id)
                _game.value = game

            } catch(_: Exception){}

        }

    }
}