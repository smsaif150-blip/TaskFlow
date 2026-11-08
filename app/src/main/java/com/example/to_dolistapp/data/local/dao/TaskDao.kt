package com.example.to_dolistapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.to_dolistapp.data.local.entity.Task

@Dao
interface TaskDataDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)
}