package com.example.to_dolistapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val category: String,
    val priority: String,
    val isComplete: Boolean,
    val dueDate: Long,
    val reminderTime: Long?,
    val createdAt: Long,
    val updateAt: Long
)
