package com.example.artspace

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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      ArtSpaceTheme {

        NavHost(navController = navController, startDestination = Screen.Home.route) {

          composable(
            Screen.Home.route + "/{id}", arguments = listOf(navArgument("id") {
              type = NavType.IntType
              defaultValue = 0
            })
          ) {

            // TODO: Add HomePage composable

          }

          composable(
            Screen.Artist.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })

          ) {

            // TODO: Add ArtistPage composable

          }

        }
      }
    }
  }
}
