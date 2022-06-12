package com.example.enozomtask.model.remote_source

import com.example.enozomtask.network.RetrofitClient
import com.example.enozomtask.network.RetrofitInterface
import com.example.enozomtask.pojo.TaskResponse
import okhttp3.RequestBody

class RemoteSource private constructor() {
    private lateinit var retrofit: RetrofitInterface

    init {
        retrofit = RetrofitClient.getInstance().create(RetrofitInterface::class.java)
    }

    companion object {
        private val remoteSource: RemoteSource? = null

        fun getInstance(): RemoteSource {
            return remoteSource ?: RemoteSource()
        }
    }

    suspend fun getData(): TaskResponse {
        return retrofit.getDataFromApi()
    }

    suspend fun submitResult(body: RequestBody) {
        retrofit.submitToApi(body)
    }
}