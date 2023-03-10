package com.arc8coder.crossword.tile.`is`

fun isTileBrown(value: Int): Boolean {
    return when(value) {
        17 -> true
        29 -> true
        33 -> true
        43 -> true
        49 -> true
        65 -> true
        57 -> true
        71 -> true
        155 -> true
        161 -> true
        169 -> true
        177 -> true
        183 -> true
        193 -> true
        197 -> true
        209 -> true
        else -> false
    }
}