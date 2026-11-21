package com.example.to_dolistapp.utils

import com.example.to_dolistapp.R
import com.example.to_dolistapp.utils.Collections.ALL
import com.example.to_dolistapp.utils.Collections.WORK
import com.example.to_dolistapp.utils.Collections.PERSONAL
import com.example.to_dolistapp.utils.Collections.SHOPPING
import com.example.to_dolistapp.utils.Collections.HEALTH
import com.example.to_dolistapp.utils.Collections.FAVORITE
import com.example.to_dolistapp.utils.Collections.OTHER

data class Category(
    val name: String,
    val image: Int
)

fun CategoryData(): List<Category> {
    return listOf(
        Category(ALL, R.drawable.all),
        Category(WORK, R.drawable.work),
        Category(PERSONAL, R.drawable.personal),
        Category(SHOPPING, R.drawable.shoppings),
        Category(HEALTH, R.drawable.health),
        Category(FAVORITE, R.drawable.star),
        Category(OTHER, R.drawable.other)
    )
}



