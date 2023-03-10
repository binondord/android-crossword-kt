package com.arc8coder.crossword.color

import androidx.compose.ui.graphics.Color
import com.arc8coder.crossword.ui.theme.Purple200
import com.arc8coder.crossword.ui.theme.Teal200

fun getWordPanelColor(value: Int): Color {
    return when(true) {
        (value % 2 == 0) -> Teal200
        else -> Purple200
    }
}