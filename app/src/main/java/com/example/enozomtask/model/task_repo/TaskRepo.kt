package com.example.enozomtask.model.task_repo

import com.example.enozomtask.model.remote_source.RemoteSource
import com.example.enozomtask.pojo.TaskResponse
import com.example.enozomtask.pojo.TaskResult
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class TaskRepo private constructor(private val remoteSource: RemoteSource) : IRepo {
    companion object {
        private val taskRepo: TaskRepo? = null

        fun getInstance(remoteSource: RemoteSource): TaskRepo {
            return taskRepo ?: TaskRepo(remoteSource)
        }
    }

    override suspend fun getData(): TaskResponse {
        return remoteSource.getData()
    }

    override suspend fun submitData(result: TaskResult) {
        val jsonReq = JSONObject()
        jsonReq.put("Password", result)
        val requestedBody = jsonReq.toString().toRequestBody("application/json".toMediaTypeOrNull())

        remoteSource.submitResult(requestedBody)
    }
}