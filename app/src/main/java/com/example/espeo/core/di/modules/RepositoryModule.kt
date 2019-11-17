package com.example.espeo.core.di.modules

import com.example.espeo.core.mapper.Mapper
import com.example.espeo.feature.data.datasource.StudentRemoteDataSource
import com.example.espeo.feature.datasource.mapper.NetworkStudentMapper
import com.example.espeo.feature.datasource.model.NetworkStudent
import com.example.espeo.feature.datasource.remote.StudentApi
import com.example.espeo.feature.datasource.remote.StudentRemoteDataSourceImpl
import com.example.espeo.feature.domain.model.Student
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideStudentApi(retrofit: Retrofit): StudentApi {
        return retrofit.create(StudentApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkStudentMapper(): Mapper<NetworkStudent, Student> {
        return NetworkStudentMapper()
    }

    @Singleton
    @Provides
    fun provideStudentRemoteDataSource(
        studentApi: StudentApi,
        mapper: Mapper<NetworkStudent, Student>
    ): StudentRemoteDataSource {
        return StudentRemoteDataSourceImpl(studentApi, mapper)
    }

}