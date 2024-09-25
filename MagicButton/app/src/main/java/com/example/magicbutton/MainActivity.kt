package com.example.magicbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.magicbutton.ui.theme.MagicButtonTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MagicButtonTheme {
        MagicButtonApp()
      }
    }
  }
}

/*
@Preview
@Composable
fun DiceRollerApp() {

}

@Composable
fun DiceWithButtonAndImage() {

}
 */

@Preview
@Composable
fun MagicButtonApp() {
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    // This is where we are going to put our own composable
    MagicButton(modifier = Modifier.padding(innerPadding))
  }
}

@Composable
fun MagicButton(modifier: Modifier = Modifier) {
  var image by remember { mutableStateOf(R.drawable.ace_of_clubs) }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()
  ) {
    Image(painter = painterResource(id = image),
          contentDescription = stringResource(R.string.card_image),
          modifier = Modifier
            .padding(16.dp)
            .clickable {
              val randomKey = (0..7).random()
              println(randomKey)
              image = getImageResource(randomKey)
            })
  }
}

fun getImageResource(key: Int): Int {
  return when (key) {
    0 -> R.drawable.__of_clubs
    1 -> R.drawable._0_of_clubs
    2 -> R.drawable.__of_hearts
    3 -> R.drawable._0_of_hearts
    4 -> R.drawable.__of_spades
    5 -> R.drawable._0_of_spades
    6 -> R.drawable.__of_diamonds
    7 -> R.drawable._0_of_diamonds
    else -> R.drawable.ace_of_clubs
  }
}
