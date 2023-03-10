package com.arc8coder.crossword.tile.`is`

fun isTileBlue(value: Int): Boolean {
    return when(value) {
        21 -> true
        25 -> true
        77 -> true
        81 -> true
        85 -> true
        89 -> true
        137 -> true
        141 -> true
        145 -> true
        149 -> true
        201 -> true
        205 -> true
        else -> false
    }
}