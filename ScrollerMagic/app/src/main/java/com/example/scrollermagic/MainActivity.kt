package com.example.scrollermagic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollermagic.ui.theme.ScrollerMagicTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println("onCreate event")
    enableEdgeToEdge()
    setContent {
      ScrollerMagicTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          App(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Composable
fun App(modifier: Modifier = Modifier) {
  Column(modifier = modifier) {

    RoundBox(modifier = modifier)
    MagicScrollableRow(modifier = modifier)
    MagicScrollableColumn(modifier = modifier)
  }
}

@Composable
fun MagicScrollableRow(modifier: Modifier = Modifier) {
  Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
    repeat(30) {
      MagicBox(number = it)
    }
  }
}

@Composable
fun MagicScrollableColumn(modifier: Modifier = Modifier) {
  Column(modifier = modifier.verticalScroll(rememberScrollState())) {
    repeat(30) {
      MagicBox(number = it)
    }
  }
}

@Composable
fun RoundBox(modifier: Modifier) {
  Box(
    modifier = modifier
      .size(100.dp)
      .border(
        BorderStroke(2.dp, MaterialTheme.colorScheme.outline), CircleShape
      )
      .clip(CircleShape)

  ) {
    Text(text = "Round Box")
  }
}

@Composable
fun MagicBox(number: Int) {
  Card(
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),
    modifier = Modifier
      .size(width = 240.dp, height = 100.dp)
  ) {
    Text(
      text = "Magic Box $number",
      modifier = Modifier
        .padding(16.dp),
      textAlign = TextAlign.Center,
    )
  }
}