package com.example.client

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Grid(color : GameResponse)
{
    val gameState  = color.responseGameState

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White)
    {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (rowIndex in gameState.indices) {
                Row {
                    for (colIndex in gameState[rowIndex].indices) {
                        val cellValue = gameState[rowIndex][colIndex]

                        Cell(
                            color = cellValue,
                            onClick = { clickedValue ->
                            })
                    }
                }
            }
        }
        }
}

@Composable
fun Cell(
    color: Color,
    onClick: (Color) -> Unit
) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .padding(10.dp)
            .clickable { onClick(color) }
            .background(color = color),
    )
}
