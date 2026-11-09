package com.example.to_dolistapp.navigations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.example.to_dolistapp.screens.HomeScreen
import com.example.to_dolistapp.screens.SplashScreen

@Composable
fun MyNavigation()
{
    val navController = rememberNavController()

    val currentStackBack = navController.currentBackStackEntryAsState()
    val currentRoute = currentStackBack.value?.destination?.route

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute=="home",
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = Color.White
                ) {
                    Icon(imageVector = Icons.Default.Home,null, modifier = Modifier.weight(1f))

                }
            }


        }
    ) {innerPadding->

        NavHost(
            navController = navController,
            startDestination = "splash",
//            enterTransition = { EnterTransition.None},
//            exitTransition = { ExitTransition.None}
        ) {
            composable("splash")
            {
                SplashScreen {
                    navController.navigate("home")
                    {
                        popUpTo("splash")
                        {
                            inclusive = true
                        }
                    }
                }
            }
            composable("home")
            {
                HomeScreen()
            }
        }
    }



}