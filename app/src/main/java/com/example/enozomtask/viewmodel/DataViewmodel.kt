package com.example.enozomtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enozomtask.model.task_repo.IRepo
import com.example.enozomtask.pojo.TaskResponse
import com.example.enozomtask.pojo.TaskResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataViewmodel(private val taskRepo: IRepo) : ViewModel() {
    private var dataMutableLiveData = MutableLiveData<TaskResponse>()
    var dataLiveData: LiveData<TaskResponse> = dataMutableLiveData

    fun getDataFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepo.getData()
            withContext(Dispatchers.Main) {
                dataMutableLiveData.postValue(response)
            }
        }
    }

    fun submitResult(result: TaskResult) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = taskRepo.submitData(result)
        }
    }
}