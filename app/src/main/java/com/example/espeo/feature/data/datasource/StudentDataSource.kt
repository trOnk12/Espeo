package com.example.espeo.feature.data.datasource

import com.example.espeo.feature.domain.model.Student
import io.reactivex.Single

interface StudentRemoteDataSource {
    fun get(): Single<List<Student>>
}