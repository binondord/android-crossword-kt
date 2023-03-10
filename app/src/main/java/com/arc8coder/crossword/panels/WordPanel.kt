package com.arc8coder.crossword.panels

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import com.arc8coder.crossword.color.getWordPanelColor
import com.arc8coder.crossword.holder.panelHolder
import com.arc8coder.crossword.words.words
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun WordPanel(innerPadding: PaddingValues, letterChunks: List<List<Int>>) {
    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(top = 0.dp)
            .fillMaxWidth()
    ) {
        items(letterChunks) {
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                var panelWord = panelHolder()
                //val textInPanelTile = panelWord[value]

                val wordsMap = words()
                val wordKeys = wordsMap.keys.toTypedArray()

                val word = wordKeys.random()

                val randomValues = MutableList(word.length) { Random.nextInt(0, word.length) }

                val randomIndex = Random.nextInt(randomValues.size)
                val randomElements = randomValues.asSequence().shuffled().take(1).toList()
                randomValues.removeIf { i -> randomElements.contains(i) }


                it.forEach { value ->
                    Box(
                        modifier = Modifier
                            .size(35.dp)
                            .padding(2.dp)
                            .background(getWordPanelColor(value))
                            .selectable(
                                enabled = true,
                                selected = false,
                                onClick = {
                                    Log.e("TestApp", "Row onClick col: $value")
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        val num = randomElements.first();
                        val textInPanelTile = if (word.length > value) word[value] else word[0]

                        println("word: $word")
                        println("numFromRandom: $num")

                        Text(
                            text = "$textInPanelTile",
                            fontSize = 14.sp,
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
