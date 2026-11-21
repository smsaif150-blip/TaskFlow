package com.example.to_dolistapp.navigations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.example.to_dolistapp.R
import com.example.to_dolistapp.screens.AddTaskScreen
import com.example.to_dolistapp.screens.HomeScreen
import com.example.to_dolistapp.screens.SplashScreen
import com.example.to_dolistapp.ui.theme.PrimaryPurple
import com.example.to_dolistapp.ui.theme.TextSecondary
import com.example.to_dolistapp.ui.theme.White
import com.example.to_dolistapp.viewmodel.AddTaskViewModel

@Composable
fun MyNavigation()
{
    val navController = rememberNavController()
    val addTaskViewModel: AddTaskViewModel = viewModel()

    val currentStackBack = navController.currentBackStackEntryAsState()
    val currentRoute = currentStackBack.value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute=="home") {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    containerColor = Color.White,

                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                            .clickable{

                            }.padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Icon(painter = painterResource(R.drawable.home),null, tint =
                            PrimaryPurple
                        )

                        Text("Home", fontSize = 12.sp)
                    }

                    Column(
                        modifier = Modifier.weight(1f)
                            .clickable{

                            }.padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Icon(painter = painterResource(R.drawable.calendar),null, tint =
                            if (currentRoute=="calender")
                            {
                                PrimaryPurple
                            }
                            else{
                                TextSecondary
                            }
                        )

                        Text("Calender", fontSize = 12.sp)
                    }



                    Column(
                        modifier = Modifier.weight(1f)
                            .padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        FloatingActionButton(onClick = {
                            navController.navigate("addTask")
                        },
                            shape = CircleShape,
                            containerColor = PrimaryPurple
                        ) {
                            Icon(imageVector = Icons.Default.Add,null, tint = White)
                        }

                    }


                    Column(
                        modifier = Modifier.weight(1f)
                            .clickable{

                            }.padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Icon(painter = painterResource(R.drawable.analytics),null, tint =
                            if (currentRoute=="analytics")
                            {
                                PrimaryPurple
                            }
                            else{
                                TextSecondary
                            }
                        )

                        Text("Analytics", fontSize = 12.sp)
                    }


                    Column(
                        modifier = Modifier.weight(1f)
                            .clickable{

                            }.padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Icon(painter = painterResource(R.drawable.settings),null, tint =
                            if (currentRoute=="settings")
                            {
                                PrimaryPurple
                            }
                            else{
                                TextSecondary
                            }
                        )

                        Text("Settings", fontSize = 12.sp)
                    }


                }
            }
        }
    ) {innerPadding->

        NavHost(
            navController = navController,
            startDestination = "splash",
            enterTransition = { EnterTransition.None},
            exitTransition = { ExitTransition.None},
           // modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())// for lazyColumn to show the top of Bottom bar
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
                Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()))
                {
                    HomeScreen()
                }

            }
            composable("addTask")
            {
                AddTaskScreen(navController,addTaskViewModel)
            }
        }
    }



}