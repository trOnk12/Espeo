package com.example.espeo.feature.domain.usecase

import com.example.espeo.feature.domain.repository.StudentRepository
import javax.inject.Inject

class GetStudents
@Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke() = studentRepository.getStudents()
}