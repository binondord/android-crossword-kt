package com.arc8coder.crossword.panels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.arc8coder.crossword.holder.puzzleHolder
import com.arc8coder.crossword.holder.puzzleHolderInt
import com.arc8coder.crossword.words.words
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Screen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var selectedItem by remember{ mutableStateOf( "") }
    val scrollState = rememberLazyListState()

    val enableSelectable = derivedStateOf {
        !scrollState.isScrollInProgress
    }

    var showKeyboard = remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    //experimental
    // val keyboard = LocalSoftwareKeyboardController.current

    val lists =  puzzleHolderInt()
    val letters =  (1..20).toMutableList()
    val listChunks = lists.chunked(15)
    val wordsMap = words()
    val letterChunks: List<List<Int>> = letters.chunked(10)

    /*
    LaunchedEffect(focusRequester) {
        if (showKeyboard.value) {
            focusRequester.requestFocus()
            delay(100) // Make sure you have delay here
            keyboard?.show()
        }
    }
    */

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn {
                items(wordsMap.count()) { index ->
                    val wordKeys = wordsMap.keys.toTypedArray()
                    val word = wordKeys[index]
                    val count = index + 1
                    Text(text = "$count $word")
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("Crossword Puzzle") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Submit") },
                onClick = { /* fab click handler */ }
            )
        }
    ) { innerPadding ->
        val width = 400.dp
        val height = 200.dp
        Box(modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .drawWithCache {
                onDrawWithContent {
                    // draw behind the content
                    //drawLine(Color.Black, Offset.Zero, Offset(width.toPx(), height.toPx()), 3f)
                    // draw the content
                    drawContent()
                    // draw in front of the content
                    // here -- drawLine(Color.Black, Offset(0f, height.toPx()), Offset(width.toPx(), 0f), 3f)
                }
            }
        ) {
            Column {
                PuzzlePanel(innerPadding, listChunks)
                WordPanel(innerPadding, letterChunks)
                DefinitionPanel(innerPadding)
            }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Your word:") },
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .width(200.dp)
                /*.fillMaxWidth()
                .focusRequester(focusRequester)*/,
            )
        }
    }
}
