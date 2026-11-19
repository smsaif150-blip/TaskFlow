package com.example.to_dolistapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.to_dolistapp.R
import com.example.to_dolistapp.ui.theme.DividerColor
import com.example.to_dolistapp.ui.theme.ErrorRed
import com.example.to_dolistapp.ui.theme.HeaderGradientEnd
import com.example.to_dolistapp.ui.theme.Lavender
import com.example.to_dolistapp.ui.theme.PrimaryPurple
import com.example.to_dolistapp.ui.theme.Primary_Purple
import com.example.to_dolistapp.ui.theme.SecondaryText
import com.example.to_dolistapp.ui.theme.SuccessGreen
import com.example.to_dolistapp.ui.theme.TextSecondary
import com.example.to_dolistapp.ui.theme.WarningOrange
import com.example.to_dolistapp.ui.theme.White
import com.example.to_dolistapp.utils.CatetegoryData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navController: NavController)
{

    val CategoryItem = CatetegoryData()
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

        var isReminderEnabled by remember {
            mutableStateOf(false)
        }

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




                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {

                        Icon(painter = painterResource(R.drawable.outline_arrow_back_24),
                            contentDescription = null,
                            tint = White)
                    }

                    Text("Add Task", fontSize = 24.sp, color = White, modifier = Modifier.padding(start = 16.dp))

                }
            }

            Card(modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
                elevation = CardDefaults.cardElevation(3.dp),
                colors = CardDefaults.cardColors(White)) {

                Column(modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())) {

                    HeaderSection("Task title *", R.drawable.t)

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp).height(50.dp)
                          ,
                        placeholder = {
                            Text("Enter task title...", color = TextSecondary)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Primary_Purple,
                            unfocusedBorderColor = DividerColor
                        ),
                        shape = RoundedCornerShape(15.dp)
                    )

                    HeaderSection("Description (Optional)",R.drawable.menu)

                    OutlinedTextField(value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth().height(100.dp)
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp),
                        shape = RoundedCornerShape(12.dp),
                        placeholder = {
                            Text("Enter task description",
                                fontSize = 18.sp,
                                color = SecondaryText
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Primary_Purple,
                            unfocusedBorderColor = DividerColor
                        )
                        )

                    HeaderSection("Category",R.drawable.category)

                    LazyRow(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp, top =4.dp)

                    ) {
                        items(CategoryItem){ item->
                            Spacer(modifier = Modifier.padding(start = 8.dp))
                            Box(modifier = Modifier.wrapContentWidth().height(40.dp)
                                .background(PrimaryPurple.copy(alpha = 0.05f), shape = RoundedCornerShape(20.dp))
                                .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(20.dp))
                                .padding(horizontal = 10.dp),
                                contentAlignment = Alignment.Center)
                            {
                                Row() {

                                    Image(painter = painterResource(item.image), contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        colorFilter = ColorFilter.tint(PrimaryPurple))

                                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                                    Text(item.name, fontSize = 15.sp,
                                        color = Primary_Purple,
                                        fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }


                HeaderSection("Priority",R.drawable.star)


                    Row(modifier = Modifier.fillMaxWidth().height(40.dp).
                    padding(start = 16.dp, end = 16.dp, top = 4.dp)) {

                        Box(modifier = Modifier.weight(1f).fillMaxHeight()
                            .background(color = Primary_Purple.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(24.dp))
                            .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(24.dp))
                            .clickable{},
                            contentAlignment = Alignment.Center)
                        {
                            Row(horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(12.dp).
                                background(color = SuccessGreen, shape = CircleShape))

                                Spacer(modifier = Modifier.padding(horizontal = 6.dp))

                                Text("Low", fontSize = 15.sp, color = Primary_Purple)
                            }
                        }
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                        Box(modifier = Modifier.weight(1f).fillMaxHeight()
                            .background(color = Primary_Purple.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(24.dp))
                            .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(24.dp))
                            .clickable{},
                            contentAlignment = Alignment.Center)
                        {
                            Row(horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(12.dp).
                                background(color = WarningOrange, shape = CircleShape))

                                Spacer(modifier = Modifier.padding(horizontal = 6.dp))

                                Text("Medium", fontSize = 15.sp, color = Primary_Purple)
                            }
                        }

                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                        Box(modifier = Modifier.weight(1f).fillMaxHeight()
                            .background(color = Primary_Purple.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(24.dp))
                            .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(24.dp))
                            .clickable{},
                            contentAlignment = Alignment.Center)
                        {
                            Row(horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(12.dp).
                                background(color = ErrorRed, shape = CircleShape))

                                Spacer(modifier = Modifier.padding(horizontal = 6.dp))

                                Text("High", fontSize = 15.sp, color = Primary_Purple)
                            }
                        }
                    }

                    HeaderSection("Due Date",R.drawable.calendar)


                    Box(modifier = Modifier.fillMaxWidth().height(48.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp)
                        .background(color = White, shape = RoundedCornerShape(16.dp))
                        .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(16.dp)))
                    {
                        Row {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(1f).fillMaxHeight().clickable{}) {

                                Box(modifier = Modifier.size(32.dp)
                                    .background(color = Primary_Purple.copy(alpha = 0.15f),
                                        shape = CircleShape
                                    ),
                                    contentAlignment = Alignment.Center)
                                {
                                    Icon(painter = painterResource(R.drawable.calendar),null,
                                        tint = Primary_Purple, modifier = Modifier.size(20.dp))
                                }

                                Spacer(modifier = Modifier.padding(horizontal = 6.dp))

                                Text("Select Date", fontSize = 16.sp, color = SecondaryText)

                            }

                            VerticalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))

                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(1f).fillMaxHeight().clickable{}) {

                                Box(modifier = Modifier.size(32.dp)
                                    .background(color = Primary_Purple.copy(alpha = 0.15f),
                                        shape = CircleShape
                                    ),
                                    contentAlignment = Alignment.Center)
                                {
                                    Icon(painter = painterResource(R.drawable.myclock),null,
                                        tint = Primary_Purple, modifier = Modifier.size(20.dp))
                                }

                                Spacer(modifier = Modifier.padding(horizontal = 6.dp))

                                Text("Select time", fontSize = 16.sp, color = SecondaryText)
                            }
                        }
                    }

                    HeaderSection("Reminder (Optional)", R.drawable.bell)


                    Box(modifier = Modifier.fillMaxWidth().height(48.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp)
                        .background(color = Primary_Purple.copy(alpha = 0.15f), shape = RoundedCornerShape(16.dp))
                        .border(width = 2.dp, color = DividerColor, shape = RoundedCornerShape(16.dp)))
                    {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
                            Spacer(modifier = Modifier.padding(start = 12.dp))
                            Box(modifier = Modifier.size(32.dp)
                                .background(color = Primary_Purple.copy(alpha = 0.15f),
                                    shape = CircleShape
                                ),
                                contentAlignment = Alignment.Center)
                            {
                                Icon(painter = painterResource(R.drawable.notification),null,
                                    tint = Primary_Purple, modifier = Modifier.size(20.dp))
                            }


                            Text(
                                "Set Reminder",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 16.dp)
                                )


                            Spacer(modifier = Modifier.weight(1f))

                            Switch(
                                checked = isReminderEnabled,
                                onCheckedChange = {
                                    isReminderEnabled = it
                                }
                            )

                            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 16.dp))

                }
            }

          Button(onClick = {},
              colors =ButtonDefaults.buttonColors(Primary_Purple),
              modifier = Modifier.fillMaxWidth().height(44.dp).padding(horizontal = 24.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
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



@Composable
fun HeaderSection(text: String,image: Int)
{
    Row(modifier = Modifier.padding(start = 16.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(40.dp)
            .background(color = Primary_Purple.copy(alpha = 0.15f),
                shape = CircleShape
            ),
            contentAlignment = Alignment.Center)
        {
            Image(painter = painterResource(image),null,
                colorFilter =ColorFilter.tint(PrimaryPurple),
                modifier = Modifier.size(20.dp)
            )
        }

        Text(text,
            color = Primary_Purple, fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 12.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun showTaskScreen()
{
    val navController: NavController = rememberNavController()
    AddTaskScreen(navController)
}