package com.arc8coder.crossword.panels

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arc8coder.crossword.ui.theme.Purple200
import com.arc8coder.crossword.ui.theme.Teal200

@Composable
fun CustomLazyRow(innerPadding: PaddingValues, colIdx: Int) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Teal200)
    ) {
        LazyRow(contentPadding = innerPadding,
            modifier = Modifier
                .border(width = 1.dp, color = Purple200)
                .selectable(
                    enabled = true,
                    selected = false,
                    onClick = {
                        Log.e("TestApp", "Row onClick col: $colIdx")
                    }
                )
            /*
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        Log.e("TestApp", "MotionEvent.ACTION_DOWN")
                    }
                    MotionEvent.ACTION_MOVE -> {
                        Log.e("TestApp", "MotionEvent.ACTION_MOVE")
                    }
                    MotionEvent.ACTION_UP -> {
                        Log.e("TestApp", "MotionEvent.ACTION_UP")
                    }
                    else -> false
                }
                false
            }*/
        ) {
            items(count = 7) { index ->
                Text(
                    "A $index - $colIdx",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .border(width = 1.dp, color = Teal200)
                        .height(50.dp)
                        .width(50.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .wrapContentHeight(Alignment.CenterVertically)
                )
            }
        }
    }
}
