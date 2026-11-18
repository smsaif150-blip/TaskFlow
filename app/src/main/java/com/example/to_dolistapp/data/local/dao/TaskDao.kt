package com.example.to_dolistapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.to_dolistapp.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDataDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("DELETE FROM tasks WHERE id= :taskId")
    suspend fun deleteTaskById(taskId: Int)

    @Query("SELECT * FROM tasks")
     fun getAllTask(): Flow<List<Task>>

}