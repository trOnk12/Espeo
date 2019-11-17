package com.example.espeo.data.repository

import com.example.espeo.data.datasource.StudentRemoteDataSource
import com.example.espeo.domain.model.Student
import com.example.espeo.domain.repository.StudentRepository
import io.reactivex.Single
import javax.inject.Inject

class StudentRepositoryImpl
@Inject constructor(
    private val studentRemoteDataSource: StudentRemoteDataSource
) : StudentRepository {

    override fun getStudents(): Single<List<Student>> =
        studentRemoteDataSource.get()

}