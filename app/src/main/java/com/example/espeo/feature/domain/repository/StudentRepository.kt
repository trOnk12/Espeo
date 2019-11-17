package com.example.espeo.feature.domain.repository

import com.example.espeo.feature.domain.model.Student
import io.reactivex.Single

interface StudentRepository {
    fun getStudents() : Single<List<Student>>
}