package com.example.to_dolistapp.screens

import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_dolistapp.R
import com.example.to_dolistapp.ui.theme.HeaderGradientEnd
import com.example.to_dolistapp.ui.theme.Lavender
import com.example.to_dolistapp.ui.theme.PrimaryPurple
import com.example.to_dolistapp.ui.theme.Primary_Purple
import com.example.to_dolistapp.ui.theme.TextSecondary
import com.example.to_dolistapp.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen()
{


    Scaffold(
     /*   topBar = {
            TopAppBar(
                title = {
                    Text("Add Task", fontSize =28.sp, color = White)
                },
                modifier = Modifier.clip(shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryPurple),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.outline_arrow_back_24),null, tint = White)
                    }
                }
            )
        }*/
    ) { innerpadding->

        Column(modifier = Modifier.padding(innerpadding).background(color = Lavender)) {
            Box(
                modifier = Modifier.fillMaxWidth().height(80.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Primary_Purple, HeaderGradientEnd
                            )
                        ),
                        shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                    ),
            )
            {
                Row(modifier = Modifier.fillMaxSize().padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start) {


                    Icon(painter = painterResource(R.drawable.outline_arrow_back_24),
                        contentDescription = null,
                        tint = White)

                    Text("Add Task", fontSize = 24.sp, color = White, modifier = Modifier.padding(start = 16.dp))

                }
            }

            Card(modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .background(color = White)
                .padding(16.dp),
                elevation = CardDefaults.cardElevation(3.dp)) {

                Column(modifier = Modifier.fillMaxSize()) {

                    Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(40.dp)
                            .background(color = Primary_Purple.copy(alpha = 0.15f),
                                shape = CircleShape
                            ),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(R.drawable.t),null,
                                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(PrimaryPurple)
                            )
                        }

                        Text("Task Title *",
                            color = Primary_Purple, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 12.dp))
                    }


                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp).height(50.dp),
                        placeholder = {
                            Text("Enter task title...", color = TextSecondary,)
                        },
                        colors = OutlinedTextFieldDefaults.colors(

                        )
                    )

                }


            }

          Button(onClick = {},
              colors =ButtonDefaults.buttonColors(Primary_Purple),
              modifier = Modifier.fillMaxWidth().height(44.dp).padding(horizontal = 24.dp)) {
              Row {
                  Icon(imageVector = Icons.Default.Add,null, tint = White,
                      modifier = Modifier.padding(end = 8.dp))
                  Text("Add Task", fontSize = 16.sp, fontWeight = FontWeight.Bold)
              }
          }

            Spacer(modifier = Modifier.padding(top = 16.dp))

        }
        
//        Column(modifier = Modifier.fillMaxSize().background(color = Lavender)
//            .padding(innerpadding)) {
//            Card(modifier = Modifier.weight(1f).padding(16.dp),
//                colors = CardDefaults.cardColors(White)
//                ) {
//
//            }
//
//            Button(onClick = {},
//                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
//
//            }
//        }

    }
}

@Preview(showBackground = true)
@Composable
fun showTaskScreen()
{
    AddTaskScreen()
}