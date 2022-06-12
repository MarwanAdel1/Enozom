package com.example.enozomtask.network

import com.example.enozomtask.model.Constants
import com.example.enozomtask.pojo.TaskResponse
import com.google.gson.JsonObject
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitInterface {
    @Headers(
        "x-api-key: ${Constants.API_KEY}",
    )
    @GET("GetMyTask")
    suspend fun getDataFromApi(): TaskResponse


    @Headers(
        "x-api-key: ${Constants.API_KEY}",
    )
    @POST("SubmitResult")
    suspend fun submitToApi(
        @Body body: RequestBody
    )
}