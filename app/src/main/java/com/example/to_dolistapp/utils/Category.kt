package com.example.to_dolistapp.utils

import com.example.to_dolistapp.R

data class Category(
    val name: String,
    val image: Int
)

fun CatetegoryData(): List<Category> {
    return listOf(
        Category("All", R.drawable.all),
        Category("Work", R.drawable.work),
        Category("Personal", R.drawable.personal),
        Category("Shopping", R.drawable.shoppings),
        Category("Health", R.drawable.health),
        Category("Favorite", R.drawable.star),
        Category("Other", R.drawable.other)
    )
}



