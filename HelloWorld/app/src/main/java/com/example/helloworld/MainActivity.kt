package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HelloWorldTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
          ) {

            HelloWorld(
              name = "Hendrix", modifier = Modifier.padding(innerPadding)
            )
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!", modifier = modifier
  )
}

@Composable
fun HelloWorld(name: String, modifier: Modifier = Modifier) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = CenterHorizontally,
    modifier = modifier,
  ) {
    Box {
      Text(
        text = "Hey there!", fontSize = 40.sp
      )
    }
    Row {
      Text(
        text = name,
        fontSize = 40.sp,
      )
      Text(
        text = "HELLO", fontSize = 20.sp, fontWeight = FontWeight.Bold
      )
    }

  }

}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
  HelloWorldTheme {
    HelloWorld("Hendrix")
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  HelloWorldTheme {
    Greeting("Hendrix")
  }
}