package com.example.myapplication.ui.presentation.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.repository.AcademicTaskRepository
import com.example.myapplication.domain.usecase.AddTaskUseCase
import com.example.myapplication.domain.usecase.GetTasksUseCase

class AcademicTaskViewModelFactory(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val repository: AcademicTaskRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AcademicTaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AcademicTaskViewModel(
                getTasksUseCase,
                addTaskUseCase,
                repository
            ) as T
        }

        throw IllegalArgumentException("ViewModel desconocido")
    }
}