package com.example.enozomtask.pojo

import com.google.gson.annotations.SerializedName

data class TaskResponse(
    @SerializedName("Indexes") val indexes: String,
    @SerializedName("Text") val text: String
)
