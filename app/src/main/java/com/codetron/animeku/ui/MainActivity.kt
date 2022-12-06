package com.codetron.animeku.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codetron.animeku.router.ScreenPath
import com.codetron.animeku.ui.screen.home.HomeScreen
import com.codetron.animeku.ui.screen.search.SearchScreen
import com.codetron.animeku.ui.screen.splash.SplashScreen
import com.codetron.animeku.ui.theme.AnimeKuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AnimeKuTheme {
                NavHost(navController = navController, startDestination = ScreenPath.splash) {
                    composable(ScreenPath.splash) {
                        SplashScreen(navController = navController)
                    }

                    composable(ScreenPath.home) {
                        HomeScreen(navController = navController)
                    }

                    composable(ScreenPath.search){
                        SearchScreen(navController=navController)
                    }
                }
            }
        }
    }
}