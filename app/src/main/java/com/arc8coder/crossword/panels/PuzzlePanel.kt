package com.arc8coder.crossword.panels

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arc8coder.crossword.color.getPuzzleTileColor

@Composable
fun PuzzlePanel(innerPadding: PaddingValues, listChunks: List<List<Int>>) {
    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.padding(15.dp)
    ) {
        items(listChunks) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 0.5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                it.forEach { value ->
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .background(getPuzzleTileColor(value))
                            .selectable(
                                enabled = true,
                                selected = false,
                                onClick = {
                                    Log.e("TestApp", "Row onClick col: $value")
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .wrapContentHeight(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}