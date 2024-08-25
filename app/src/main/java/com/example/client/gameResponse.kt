package com.example.client

import androidx.compose.ui.graphics.Color



data class GameResponse(
    val responseGameState : List<List<Color>>,
)

data class GameRequest(
    val requestGameState : List<List<Color>>,
)
