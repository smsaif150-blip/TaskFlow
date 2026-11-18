package com.example.to_dolistapp.repository

import com.example.to_dolistapp.data.local.dao.TaskDataDao
import com.example.to_dolistapp.data.local.entity.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDataDao) {

    suspend fun insertTask(task: Task)
    {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: Task)
    {
        taskDao.updateTask(task)
    }

    suspend fun deleteTaskById(id: Int)
    {
        taskDao.deleteTaskById(id)
    }

    fun getAllTask(): Flow<List<Task>>
    {
        return taskDao.getAllTask()
    }

}