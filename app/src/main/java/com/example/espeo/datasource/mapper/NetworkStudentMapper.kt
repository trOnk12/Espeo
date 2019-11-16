package com.example.espeo.datasource.mapper

import com.example.espeo.core.mapper.Mapper
import com.example.espeo.data.AgeValidator
import com.example.espeo.datasource.model.NetworkStudent
import com.example.espeo.domain.model.AgeStatus
import com.example.espeo.domain.model.Student

class NetworkStudentMapper : Mapper<NetworkStudent, Student> {

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