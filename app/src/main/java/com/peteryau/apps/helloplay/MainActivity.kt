package com.peteryau.apps.helloplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.peteryau.apps.helloplay.ui.theme.HelloPlayTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloPlayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VocabularyScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun VocabularyScreen(modifier: Modifier = Modifier) {
    val vocabulary = listOf(
        "apple",
        "banana",
        "courage",
        "discover",
        "elegant",
        "freedom",
        "gather",
        "horizon",
        "imagine",
        "journey",
        "knowledge",
        "luminous",
        "momentum",
        "notion",
        "ocean",
        "prosper",
        "quest",
        "radiant",
        "serenity",
        "treasure"
    )

    val (displayedWord, setDisplayedWord) = remember { mutableStateOf("ready") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This app can learn vocabulary by tapping the words below.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = displayedWord,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    if (vocabulary.isNotEmpty()) {
                        var nextWord = vocabulary[Random.nextInt(vocabulary.size)]
                        if (vocabulary.size > 1) {
                            while (nextWord == displayedWord) {
                                nextWord = vocabulary[Random.nextInt(vocabulary.size)]
                            }
                        }
                        setDisplayedWord(nextWord)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VocabularyScreenPreview() {
    HelloPlayTheme {
        VocabularyScreen()
    }
}
