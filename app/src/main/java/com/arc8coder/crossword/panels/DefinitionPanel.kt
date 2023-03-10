package com.arc8coder.crossword.panels

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arc8coder.crossword.holder.panelHolder
import com.arc8coder.crossword.words.words

@Composable
fun DefinitionPanel(innerPadding: PaddingValues) {
    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(top = 100.dp)
            .fillMaxWidth()
    ) {
        items(1) {
            var value = 100
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                var panelWord = panelHolder()
                //val textInPanelTile = panelWord[value]

                val wordsMap = words()
                val definitions = wordsMap.values.toTypedArray()

                Text(
                    text = definitions.random(),
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