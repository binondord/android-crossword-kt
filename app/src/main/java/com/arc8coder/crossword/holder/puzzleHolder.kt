package com.arc8coder.crossword.holder

fun puzzleHolder(): MutableMap<Int, String> {
    //return (1..225).toMutableList()
    return (1..9).associateWith { "" }.toMutableMap()
}

fun puzzleHolderInt(): MutableList<Int> {
    return (1..225).toMutableList()
}