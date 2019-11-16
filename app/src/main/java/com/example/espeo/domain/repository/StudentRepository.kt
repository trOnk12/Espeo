package com.example.espeo.domain.repository

import com.example.espeo.domain.model.Student
import io.reactivex.Single

interface StudentRepository {
    fun getStudents() : Single<List<Student>>
}