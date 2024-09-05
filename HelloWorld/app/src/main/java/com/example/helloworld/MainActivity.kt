package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HelloWorldTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          HelloWorld(
            name = "Hendrix",
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Composable
fun HelloWorld(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name, welcome to our App",
    modifier = modifier
  )
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