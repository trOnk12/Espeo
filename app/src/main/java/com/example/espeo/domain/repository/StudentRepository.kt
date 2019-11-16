package com.example.espeo.domain.repository

import com.example.espeo.domain.model.Student

interface StudentRepository {
    fun getStudents() : Single<List<Student>>
}