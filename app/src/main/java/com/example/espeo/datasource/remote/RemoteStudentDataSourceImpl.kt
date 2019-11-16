package com.example.espeo.datasource.remote

import com.example.espeo.core.mapper.ListMapper
import com.example.espeo.core.mapper.Mapper
import com.example.espeo.data.datasource.RemoteStudentDataSource
import com.example.espeo.datasource.model.NetworkStudent
import com.example.espeo.domain.model.Student
import io.reactivex.Single

class RemoteStudentDataSourceImpl constructor(
    private val studentApi: StudentApi,
    private val networkStudentMapper: Mapper<NetworkStudent, Student>
) : RemoteStudentDataSource {

    override fun get(): Single<List<Student>> {
        return studentApi.getStudents().map{
            networkStudentMapper.map(it)
        }
    }
}