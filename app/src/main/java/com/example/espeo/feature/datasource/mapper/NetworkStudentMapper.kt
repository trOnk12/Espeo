package com.example.espeo.feature.datasource.mapper

import com.example.espeo.core.mapper.Mapper
import com.example.espeo.feature.data.AgeValidator
import com.example.espeo.feature.datasource.model.NetworkStudent
import com.example.espeo.feature.domain.model.AgeStatus
import com.example.espeo.feature.domain.model.Student
import javax.inject.Inject

class NetworkStudentMapper
@Inject constructor() : Mapper<NetworkStudent, Student> {

    override fun map(input: NetworkStudent): Student {
        return input.run {
            Student(name, isUnderAge(), isStudent)
        }
    }

    private fun NetworkStudent.isUnderAge() =
        when (AgeValidator.isAdult(18, yearOfBirth)) {
            true -> AgeStatus.IS_NOT_UNDERAGE
            else -> AgeStatus.IS_UNDERAGE
        }

}