package com.example.to_dolistapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.to_dolistapp.screens.HomeScreen
import com.example.to_dolistapp.screens.SplashScreen

@Composable
fun MyNavigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash")
        {
            SplashScreen {
                navController.navigate("home")
            }
        }
        composable("home")
        {
            HomeScreen()
        }
    }
}