package com.example.espeo.data.repository

import com.example.espeo.data.datasource.RemoteStudentDataSource
import com.example.espeo.domain.model.Student
import com.example.espeo.domain.repository.StudentRepository
import io.reactivex.Single

class StudentRepositoryImpl(private val remoteStudentDataSource : RemoteStudentDataSource) : StudentRepository {

    override fun getStudents(): Single<List<Student>> =
        remoteStudentDataSource.get()

}