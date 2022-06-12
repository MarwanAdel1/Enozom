package com.example.enozomtask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.model.task_repo.IRepo

class DataViewmodelFactory(private val taskRepo: IRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DataViewmodel::class.java)) {
            DataViewmodel(taskRepo) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }

}