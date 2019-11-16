package com.example.espeo.datasource.model

import com.google.gson.annotations.SerializedName

data class NetworkStudent(
    @SerializedName("name") val name: String,
    @SerializedName("year_of_birth") val yearOfBirth: Int,
    @SerializedName("student") val isStudent: Boolean
)