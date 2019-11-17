package com.example.espeo.feature.data.repository

import com.example.espeo.feature.data.datasource.StudentRemoteDataSource
import com.example.espeo.feature.domain.model.Student
import com.example.espeo.feature.domain.repository.StudentRepository
import io.reactivex.Single
import javax.inject.Inject

class StudentRepositoryImpl
@Inject constructor(
    private val studentRemoteDataSource: StudentRemoteDataSource
) : StudentRepository {

    override fun getStudents(): Single<List<Student>> =
        studentRemoteDataSource.get()

}