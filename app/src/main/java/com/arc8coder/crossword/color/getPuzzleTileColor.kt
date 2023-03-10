package com.arc8coder.crossword.color

import androidx.compose.ui.graphics.Color
import com.arc8coder.crossword.tile.`is`.*
import com.arc8coder.crossword.ui.theme.*

fun getPuzzleTileColor(value: Int): Color {
    return when(true) {
        isTileRed(value) -> Red200
        isTileCenter(value) -> Green200
        isTileBlue(value) -> Blue200
        isTileBrown(value) -> Brown200
        isTileYellow(value) -> Yellow200
        (value % 2 == 0) -> Teal200
        else -> Teal200
    }
}