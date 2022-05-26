package com.example.composition.presentation.fragments.gamefragment

import androidx.lifecycle.ViewModel
import com.example.composition.data.GameRepositoryImpl
import com.example.composition.domain.entities.GameSettings
import com.example.composition.domain.entities.Level
import com.example.composition.domain.usecases.GenerateQuestionsUseCase
import com.example.composition.domain.usecases.GetGameSettingsUseCase

class GameViewModel: ViewModel() {
    private lateinit var gameSettings:GameSettings
    private lateinit var level: Level

    private val repository = GameRepositoryImpl
    private val generateQuestionsUseCase  = GenerateQuestionsUseCase(repository)
    private val getGameSettingsUseCase = GetGameSettingsUseCase(repository)

    fun startGame(level: Level){

    }
}