package com.example.to_dolistapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_dolistapp.R
import com.example.to_dolistapp.ui.theme.Primary_Purple
import com.example.to_dolistapp.ui.theme.SecondaryText
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavHost:()-> Unit)
{
    LaunchedEffect(true) {
        delay(1000L)
        onNavHost()
    }

    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(R.drawable.splash_screen),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
            )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.height(120.dp))

            Row {
                Text("Task", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text("Flow", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Primary_Purple)
            }
            Text("Plan your day. Achieve more", fontSize = 16.sp, color = SecondaryText)

            Spacer(modifier = Modifier.height(30.dp))

            CircularProgressIndicator(
                color = Primary_Purple,
                trackColor = Color.LightGray,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowSplash()
{
    SplashScreen {

    }
}