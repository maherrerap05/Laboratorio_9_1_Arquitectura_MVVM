package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.InMemoryTaskRepository
import com.example.myapplication.domain.usecase.AddTaskUseCase
import com.example.myapplication.domain.usecase.GetTasksUseCase
import com.example.myapplication.ui.presentation.tasks.AcademicTaskApp
import com.example.myapplication.ui.presentation.tasks.AcademicTaskViewModel
import com.example.myapplication.ui.presentation.tasks.AcademicTaskViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val repository = InMemoryTaskRepository()
        val getTasksUseCase = GetTasksUseCase(repository)
        val addTaskUseCase = AddTaskUseCase(repository)

        val factory = AcademicTaskViewModelFactory(
            getTasksUseCase,
            addTaskUseCase,
            repository
        )

        val viewModel = ViewModelProvider(
            this,
            factory
        )[AcademicTaskViewModel::class.java]

        setContent {
            AcademicTaskApp(viewModel = viewModel)
        }
    }
}