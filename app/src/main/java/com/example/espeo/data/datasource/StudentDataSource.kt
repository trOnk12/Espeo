package com.example.espeo.data.datasource

import com.example.espeo.domain.model.Student
import io.reactivex.Single

interface RemoteStudentDataSource {
    fun get(): Single<List<Student>>
}