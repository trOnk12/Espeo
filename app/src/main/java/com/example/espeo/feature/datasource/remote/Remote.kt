package com.example.espeo.feature.datasource.remote

import com.example.espeo.feature.datasource.model.NetworkStudent
import io.reactivex.Single
import retrofit2.http.GET

interface StudentApi {

    @GET
    fun getStudents(): Single<List<NetworkStudent>>

}