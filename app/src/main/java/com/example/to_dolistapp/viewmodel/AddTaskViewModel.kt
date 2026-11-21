package com.example.to_dolistapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.to_dolistapp.repository.TaskRepository
import com.example.to_dolistapp.utils.Collections.ALL
import com.example.to_dolistapp.utils.Collections.LOW
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(private val taskRepository: TaskRepository): ViewModel() {

    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var selectedCategory by mutableStateOf(ALL)
    var selectedPriority by mutableStateOf(LOW)


    fun onCategoryChange(name: String)
    {
        selectedCategory = name
    }

    fun onPriorityChange(priority: String)
    {
        selectedPriority = priority
    }

}