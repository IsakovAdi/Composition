package com.example.composition.domain.entities

data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions:Int,
    val gameSettings: GameSettings
)