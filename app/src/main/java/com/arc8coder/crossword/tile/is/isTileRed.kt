package com.arc8coder.crossword.tile.`is`

fun isTileRed(value: Int): Boolean {
    return when(value) {
        1 -> true
        8 -> true
        15 -> true
        106 -> true
        120 -> true
        211 -> true
        218 -> true
        225 -> true
        else -> false
    }
}