package com.example.to_dolistapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_dolistapp.R
import com.example.to_dolistapp.ui.theme.DeepPurple
import com.example.to_dolistapp.ui.theme.DividerColor
import com.example.to_dolistapp.ui.theme.Lavender
import com.example.to_dolistapp.ui.theme.PrimaryPurple
import com.example.to_dolistapp.ui.theme.Primary_Purple
import com.example.to_dolistapp.ui.theme.SecondaryText
import com.example.to_dolistapp.ui.theme.StatusPending
import com.example.to_dolistapp.ui.theme.SuccessGreen
import com.example.to_dolistapp.ui.theme.SurfaceWhite
import com.example.to_dolistapp.ui.theme.White

@Composable
fun HomeScreen()
{


    Scaffold { innerpadding->

        Column(modifier = Modifier.fillMaxSize().background(color = Lavender)) {

            Box(
                modifier = Modifier.fillMaxWidth().height(170.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Primary_Purple,DeepPurple
                            )
                        ),
                        shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                    ),
                )
            {
                    Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 40.dp)) {
                        Box(modifier = Modifier.size(40.dp)
                            .background(color = White.copy(alpha = 0.18f),
                                shape = RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center)
                        {
                            Icon(painter = painterResource(R.drawable.tick),
                                contentDescription = null,
                                tint = White,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(8.dp))

                        Column {
                            Text("TaskFlow", color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                            Text("Plan . Organize . Get Things Done", color = White, fontSize = 12.sp)
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Notifications,null, tint = White)
                        }
                    }


                    Card(modifier = Modifier.fillMaxWidth()
                        .padding(top = 75.dp, start = 16.dp, end = 16.dp)
                        .height(120.dp)
                        .offset(y = 35.dp),
                        colors = CardDefaults.cardColors(SurfaceWhite),
                        elevation = CardDefaults.cardElevation(4.dp)
                    )
                    {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Column(
                                modifier = Modifier.fillMaxHeight().weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Box(modifier = Modifier.size(24.dp),
                                    contentAlignment = Alignment.Center)
                                {
                                    Image(
                                        painter = painterResource(R.drawable.tick_violet),
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        colorFilter = ColorFilter.tint(PrimaryPurple),
                                        contentScale = ContentScale.Fit)
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text("7", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text("Total", fontSize = 14.sp)
                            }
                            VerticalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 18.dp))

                            Column(modifier = Modifier.fillMaxHeight().weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {

                                Box(modifier = Modifier.size(24.dp),
                                    contentAlignment = Alignment.Center)
                                {
                                    Image(
                                        painter = painterResource(R.drawable.tick_green),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp),
                                        colorFilter = ColorFilter.tint(SuccessGreen),
                                        contentScale = ContentScale.Fit
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text("3", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text("Completed", fontSize = 14.sp)
                            }

                            VerticalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 18.dp))

                            Column(modifier = Modifier.fillMaxHeight().weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Box(modifier = Modifier.size(24.dp),
                                    contentAlignment = Alignment.Center)
                                {
                                    Image(
                                        painter = painterResource(R.drawable.clock),
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        colorFilter = ColorFilter.tint(StatusPending),
                                        contentScale = ContentScale.Fit)
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text("2", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text("Pending", fontSize = 14.sp)
                            }

                            VerticalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 18.dp))

                            Column(modifier = Modifier.fillMaxHeight().weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Box(modifier = Modifier.size(24.dp),
                                    contentAlignment = Alignment.Center)
                                {
                                    Image(
                                        painter = painterResource(R.drawable.calendar),
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        colorFilter = ColorFilter.tint(PrimaryPurple),
                                        contentScale = ContentScale.Fit)
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text("2", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text("OverDue", fontSize = 14.sp, color = StatusPending)
                            }
                        }

                    }

            }

            Spacer(modifier = Modifier.padding(top = 50.dp))

            Row {

                //search task

                Box(modifier = Modifier.weight(1.5f).height(40.dp)
                    .padding(start = 16.dp)
                    .background(color = SurfaceWhite, shape = RoundedCornerShape(20.dp))
                    .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.CenterStart
                    )
                {
                    Icon(imageVector = Icons.Default.Search,null, modifier = Modifier.padding(start = 16.dp))
                    Text(
                        "Search tasks...",
                        modifier = Modifier.padding(start = 48.dp),
                        fontSize = 16.sp,
                        color = SecondaryText
                    )
                }

                //filter

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(modifier = Modifier.size(40.dp)
                    .background(color = Primary_Purple.copy(alpha = 0.18f),
                        shape = RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(R.drawable.filter),
                        contentDescription = "Filter",
                        colorFilter = ColorFilter.tint(PrimaryPurple))
                }
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            }


            Row {

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ShowHomeScreen()
{
    HomeScreen()
}