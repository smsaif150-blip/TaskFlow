package com.example.to_dolistapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_dolistapp.data.local.dao.TaskDataDao
import com.example.to_dolistapp.data.local.entity.Task

@Database(
    entities = [Task::class],
    version = 1
)

abstract class TaskAppData: RoomDatabase() {
    abstract fun taskDataDao(): TaskDataDao
}