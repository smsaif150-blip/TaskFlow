package com.example.to_dolistapp.utils

import com.example.to_dolistapp.R

data class CardItems(
    val title: String,
    val image: Int,
    val category: String,
    val time: String
)


fun dummyData(): List<CardItems>
{
    return listOf(
        CardItems(title = "Finish Android Project", R.drawable.suitcase,"Work","Tomorrow, 9:00 AM"),
        CardItems(title = "Finish Android Project", R.drawable.suitcase,"Work","Tomorrow, 9:00 AM"),
        CardItems(title = "Finish Android Project", R.drawable.suitcase,"Work","Tomorrow, 9:00 AM"),
        CardItems(title = "Finish Android Project", R.drawable.suitcase,"Work","Tomorrow, 9:00 AM"),
        CardItems(title = "Finish Android Project", R.drawable.suitcase,"Work","Tomorrow, 9:00 AM"),
        CardItems(title = "Finish Android Project", R.drawable.suitcase,"Work","Tomorrow, 9:00 AM"),
    )
}