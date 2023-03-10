package com.arc8coder.crossword.which

import kotlin.math.floor

fun whichRow(value: Int): Int {
    return floor((value.toDouble() - 1)/ 15).toInt() + 1
}