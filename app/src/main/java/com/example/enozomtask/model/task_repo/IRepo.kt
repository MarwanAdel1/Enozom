package com.example.enozomtask.model.task_repo

import com.example.enozomtask.pojo.TaskResponse
import com.example.enozomtask.pojo.TaskResult
import okhttp3.RequestBody

interface IRepo {
    suspend fun getData(): TaskResponse
    suspend fun submitData(result: TaskResult)
}