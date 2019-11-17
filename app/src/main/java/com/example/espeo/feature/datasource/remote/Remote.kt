package com.example.espeo.feature.datasource.remote

import com.example.espeo.feature.datasource.model.NetworkStudent
import io.reactivex.Single
import retrofit2.http.GET

interface StudentApi {

    @GET("v2/5db2e026350000a91af5527c")
    fun getStudents(): Single<List<NetworkStudent>>

}